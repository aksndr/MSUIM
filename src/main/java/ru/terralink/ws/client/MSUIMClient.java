package ru.terralink.ws.client;

import com.sun.xml.internal.ws.client.BindingProviderProperties;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import ru.terralink.common.Utils;
import ru.terralink.common.mh.SoapMessageHandler;
import ru.terralink.ws.model.REAttrDataExchangeOut;
import ru.terralink.ws.model.REDataExchangeAttrECD;
import ru.terralink.ws.model.REDataExchangeAttrFile;

import javax.activation.MimetypesFileTypeMap;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.soap.SOAPBinding;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Created by Arzamastsev on 14.12.2015.

public class MSUIMClient {

    private static final String NAME_SPACE_URL = "http://inform.gazprom.ru/C/SUIM/REDataExchange";
    private static final String WS_NAME = "REAttrDataExchangeOutService";
    private String serviceUrl;
    private String login;
    private String password;

    private ApplicationContext context;

    private List<REDataExchangeAttrFile> attrFiles = new ArrayList<>();
    private List<byte[]> chunks = new ArrayList<>();
    private String mimeType = "";

    private Map<String, Object> result = new HashMap<>();

    private REDataExchangeAttrECD message = new REDataExchangeAttrECD();

    private static final Logger logger = LoggerFactory.getLogger(MSUIMClient.class.getSimpleName());

    public MSUIMClient(String serviceUrl, String login, String password) {
        this.serviceUrl = serviceUrl;
        this.login = login;
        this.password = password;
    }

    public Map<String, Object> init() {
        try {
            context = new ClassPathXmlApplicationContext("spring/terralink/spring-config.xml");
        } catch (Exception e) {
            return failed("Failed to get ClassPathXmlApplicationContext. Exception: "+ e.toString());
        }
        return isAllowedWebService();
    }

    public Map<String, Object> addSection(String sectionName, Map<String, Object> attributes) {
        if (addSectionParamsIsInvalid(sectionName, attributes)) {
            return result;
        }

        try {
            Field field = message.getClass().getDeclaredField(sectionName);
            field.setAccessible(true);
            String fieldName = field.getName();
            String fieldType = field.getType().getName();

            Object section = context.getBean(sectionName);
            logger.info("Got section: " + sectionName);

            if (fieldType.equals("java.util.List")) {
                String methodName = "set" + fieldName;
                Method method = message.getClass().getMethod(methodName, Object.class);
                method.invoke(message, section);
            } else {
                field.set(message, section);
            }

            Field[] fields = section.getClass().getDeclaredFields();
            for (Field sectionField : fields) {
                sectionField.setAccessible(true);
                String sectionFieldName = sectionField.getName();
                String sectionFieldType = sectionField.getType().getName();

                if (attributes.containsKey(sectionFieldName)) {
                    Object fieldValue = attributes.get(sectionFieldName);
                    if (fieldValue == null) continue;

                    String stringValue = String.valueOf(fieldValue);
                    if (sectionFieldType.equals("org.joda.time.LocalDate")) {
                        sectionField.set(section, Utils.getLocalDate(stringValue));
                    } else if (sectionFieldType.equals("java.lang.String")) {
                        sectionField.set(section, stringValue);
                    } else {
                        sectionField.set(section, fieldValue);
                    }
                    logger.info("Got field: " + sectionFieldName + " field type: " + sectionFieldType+ " value: " + stringValue);
                }
            }

        } catch (IllegalArgumentException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException | ParseException e) {
            return failed("Error in addSection method. Exception: " + e.toString());
        }
        return succeed();
    }

    public Map<String, Object> addAttachment(int partSize, Map<String, Object> attributes) {
        logger.info("Started addAttachment");

        if (attributes != null) {
            try {
                if (!attributes.containsKey("Content"))
                    return failed("System does not received attachment content data");

                byte[] content = (byte[])attributes.get("Content");
                if (content.length<=0)
                    return failed("System does not received attachment content data");
                logger.info("Attachment size: " + content.length);

                String File_ID = attributes.containsKey("File_ID") ? String.valueOf(attributes.get("File_ID")) : "";
                String FILE_NAME = attributes.containsKey("FILE_NAME") ? String.valueOf(attributes.get("FILE_NAME")) : "";
                Integer NOMER = attributes.containsKey("NOMER") ? (Integer) attributes.get("NOMER") : 0;
                String USERS = attributes.containsKey("USERS") ? String.valueOf(attributes.get("USERS")) : "";
                String USERSTXT = attributes.containsKey("USERSTXT") ? String.valueOf(attributes.get("USERSTXT")) : "";
                LocalDate DATUM = attributes.containsKey("DATUM") ? Utils.getLocalDate(String.valueOf(attributes.get("DATUM"))) : null;
                Boolean Delete = attributes.containsKey("Delete") ? (Boolean) attributes.get("Delete") : false;

                String allHash = Utils.getSha1Hash(content);
                chunks = Utils.splitContent(content,partSize);
                mimeType = Utils.getMimeType(FILE_NAME);
                int currentPart = 1;
                int totalParts = chunks.size();
                for (byte[] chunk : chunks) {
                    String currentHash = Utils.getSha1Hash(chunk);
                    REDataExchangeAttrFile attrFile = new REDataExchangeAttrFile();
                    attrFile.setFileID(File_ID);
                    attrFile.setFILENAME(FILE_NAME);
                    attrFile.setNOMER(NOMER);
                    attrFile.setUSERS(USERS);
                    attrFile.setUSERSTXT(USERSTXT);
                    attrFile.setDATUM(DATUM);
                    attrFile.setDelete(Delete);
                    attrFile.setCurrentPart(currentPart);
                    attrFile.setCurrentHash(currentHash);
                    attrFile.setAllParts(totalParts);
                    attrFile.setAllHash(allHash);

                    attrFiles.add(attrFile);
                    currentPart++;
                }

            } catch (Exception e) {
                return failed("Error in addAttachment method. Exception: " + e.toString());
            }
        } else {
            logger.warn("Got empty attachment args.");
        }
        logger.info("Finished addAttachment");
        return succeed();
    }

    public Map<String, Object> doWork() {
        try {
            REAttrDataExchangeOut reAttrDataExchangeOut = getService(this.serviceUrl, this.login, this.password);
            for (REDataExchangeAttrFile attrFile : attrFiles){
                message.setAttrFile(attrFile);
                reAttrDataExchangeOut.reAttrDataExchangeOut(message);
            }
        } catch (MalformedURLException e) {
            return failed("Error in doWork method. Exception: " + e.toString());
        }
        return succeed();
    }

    private REAttrDataExchangeOut getService(String url, String login, String pass) throws MalformedURLException {
        URL wsdlUrl = new URL(url);
        QName qName = new QName(NAME_SPACE_URL, WS_NAME);
        Service service = Service.create(wsdlUrl, qName);
        REAttrDataExchangeOut reAttrDataExchangeOut = service.getPort(REAttrDataExchangeOut.class);

        BindingProvider bp = (BindingProvider) reAttrDataExchangeOut;

        Map<String, Object> requestContext = bp.getRequestContext();

        if (url != null) {
            requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
        }

        requestContext.put(BindingProviderProperties.CONNECT_TIMEOUT, 5000);
        requestContext.put(BindingProviderProperties.REQUEST_TIMEOUT, 25000);

        requestContext.put(BindingProvider.USERNAME_PROPERTY, login);
        requestContext.put(BindingProvider.PASSWORD_PROPERTY, pass);
        requestContext.put("chunks", chunks.size());

        SOAPBinding binding = (SOAPBinding) bp.getBinding();
        binding.setMTOMEnabled(true);
        List<Handler> h = binding.getHandlerChain();
        SoapMessageHandler mh = new SoapMessageHandler();
        mh.setChunks(chunks);
        mh.setMimeType(mimeType);
        h.add(mh);
        binding.setHandlerChain(h);
        return reAttrDataExchangeOut;
    }

    public REDataExchangeAttrECD getMessage() {
        return this.message;
    }

    private Map<String, Object> isAllowedWebService() {
        try {
            HttpURLConnection connection = (HttpURLConnection)  new URL( this.serviceUrl).openConnection();
            connection.setRequestMethod("GET");
            connection.getInputStream();

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                return failed("Server returned error: " + responseCode + "Message: "+ connection.getResponseMessage());
            }
        } catch (Exception e) {
            return failed("Failed to connect to URL: "+this.serviceUrl+" Exception: " + e.toString());
        }
        return succeed();
    }

    private boolean addSectionParamsIsInvalid(String sectionName, Map<String, Object> attributes) {
        if (StringUtils.isEmpty(sectionName)) {
            result = failed("Section name were undefined");
            return true;
        }
        if (CollectionUtils.isEmpty(attributes)) {
            result = failed("Attributes is undefined");
            return true;
        }
        return false;
    }


    private static Map<String, Object> succeed() {
        Map<String, Object> result = new HashMap<>();
        result.put("ok", true);
        return result;
    }

    private static Map<String, Object> succeed(Object value) {
        Map<String, Object> result = new HashMap<>();
        result.put("ok", true);
        result.put("value", value);
        return result;
    }

    private static Map<String, Object> failed(String errMsg) {
        logger.error(errMsg);
        Map<String, Object> result = new HashMap<>();
        result.put("ok", false);
        result.put("errMsg", errMsg);
        return result;
    }

}
