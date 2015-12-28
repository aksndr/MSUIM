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
import ru.terralink.ws.model.REAttrDataExchangeOut;
import ru.terralink.ws.model.REDataExchangeAttrECD;
import ru.terralink.ws.model.REDataExchangeAttrFile;

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
import java.util.HashMap;
import java.util.Map;

//Created by Arzamastsev on 14.12.2015.

public class MSUIMClient {

    private static final String NAME_SPACE_URL = "http://inform.gazprom.ru/C/SUIM/REDataExchange";
    private static final String WS_NAME = "REAttrDataExchangeOutService";
    private String serviceUrl;
    private String login;
    private String password;

    private ApplicationContext context;

    private Map<String, Object> result = new HashMap<>();
    private Map<String, Object> sections = new HashMap<>();

    private REDataExchangeAttrECD message = new REDataExchangeAttrECD();

    final Logger logger = LoggerFactory.getLogger(MSUIMClient.class.getSimpleName());

    public MSUIMClient(String serviceUrl, String login, String password) {
        this.serviceUrl = serviceUrl;
        this.login = login;
        this.password = password;
    }

    public Map<String, Object> init() {
        try {
            context = new ClassPathXmlApplicationContext("spring/terralink/spring-config.xml");
        } catch (Exception e) {
            logger.error("Failed to get ClassPathXmlApplicationContext. Error: ", e);
            return failed("Failed to get ClassPathXmlApplicationContext. Error: " + e.toString());
        }
        return isAllowedWebService();
    }

    public Map<String, Object> doWork() {
        try {
            REAttrDataExchangeOut reAttrDataExchangeOut = getService(this.serviceUrl, this.login, this.password);
            reAttrDataExchangeOut.reAttrDataExchangeOut(message);
        } catch (MalformedURLException e) {
            String errMsg = "Error in doWork method. Exception: " + e.toString();
            logger.error(errMsg);
            return failed(errMsg);
        }
        return succeed();
    }

    public Map<String, Object> addSection(String sectionName, Map<String, Object> attributes) {
        if (isValidateAddSectionParams(sectionName, attributes)) {
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
            String errMsg = "Error in buildMessage method. Exception: " + e.toString();
            logger.error(errMsg);
            return failed(errMsg);
        }
        return succeed();
    }

    public Map<String, Object> addAttachment(Map<String, Object> attributes) {
        logger.info("Started addAttachment");
        if (attributes != null) {
            try {
                String File_ID = attributes.containsKey("File_ID") ? String.valueOf(attributes.get("File_ID")) : "";
                String FILE_NAME = attributes.containsKey("FILE_NAME") ? String.valueOf(attributes.get("FILE_NAME")) : "";
                Integer NOMER = attributes.containsKey("NOMER") ? (Integer) attributes.get("NOMER") : 0;
                String USERS = attributes.containsKey("USERS") ? String.valueOf(attributes.get("USERS")) : "";
                String USERSTXT = attributes.containsKey("USERSTXT") ? String.valueOf(attributes.get("USERSTXT")) : "";
                LocalDate DATUM = attributes.containsKey("DATUM") ? Utils.getLocalDate(String.valueOf(attributes.get("DATUM"))) : null;
                Boolean Delete = attributes.containsKey("Delete") ? (Boolean) attributes.get("Delete") : false;

                REDataExchangeAttrFile AttrFile = new REDataExchangeAttrFile();
                AttrFile.setFileID(File_ID);
                AttrFile.setFILENAME(FILE_NAME);
                AttrFile.setNOMER(NOMER);
                AttrFile.setUSERS(USERS);
                AttrFile.setUSERSTXT(USERSTXT);
                AttrFile.setDATUM(DATUM);
                AttrFile.setDelete(Delete);
                AttrFile.setCurrentPart(1);
                AttrFile.setCurrentHash("");
                AttrFile.setAllParts(1);
                AttrFile.setAllHash("");

                message.addAttrFile(AttrFile);
            } catch (Exception e) {
                String errMsg = "Error in addAttachment method. Exception: " + e.toString();
                logger.error(errMsg);
                return failed(errMsg);
            }
        } else {
            logger.warn("Got empty attachment args.");
        }
        logger.info("Finished addAttachment");
        return succeed();
    }

    public REDataExchangeAttrECD getMessage() {
        return this.message;
    }

    public Map<String, Object> getSections() {
        return sections;
    }

    private Map<String, Object> isAllowedWebService() {
        try {
            HttpURLConnection connection = (HttpURLConnection)  new URL( this.serviceUrl).openConnection();
            connection.setRequestMethod("GET");
            connection.getInputStream();

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                logger.error("Web Service is not allowed " + connection.getResponseMessage());
                return failed("Failed to get ClassPathXmlApplicationContext. Error: " + responseCode);
            }
        } catch (Exception e) {
            logger.error("Web Service is not allowed " + e.getMessage());
            return failed("Failed to get ClassPathXmlApplicationContext. Error: " + e.getMessage());
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

        return reAttrDataExchangeOut;
    }

    private boolean isValidateAddSectionParams(String sectionName, Map<String, Object> attributes) {
        if (!StringUtils.isEmpty(sectionName)) {
            result = failed("Section name were undefined");
            return false;
        }
        if (!CollectionUtils.isEmpty(attributes)) {
            result = failed("Attributes is undefined");
            return false;
        }
        return true;
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
        Map<String, Object> result = new HashMap<>();
        result.put("ok", false);
        result.put("errMsg", errMsg);
        return result;
    }

}
