package ru.terralink.ws.client;

import com.sun.xml.internal.ws.client.BindingProviderProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import ru.terralink.common.mh.SoapMessageHandler;
import ru.terralink.ws.model.REAttrDataExchangeOut;
import ru.terralink.ws.model.REDataExchangeAttrECD;
import ru.terralink.ws.model.REDataExchangeAttrFile;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.soap.SOAPBinding;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by AzarovD on 22.01.2016.
 */

public class MSUIMClient2 {
    @Autowired private ReplyHelper replyHelper;
    @Autowired private AddAttachment addAttachment;
    @Autowired private REDataExchangeAttrECD message;
    @Autowired private SoapMessageHandler mh;
    private String serviceUrl;
    private String login;
    private String password;
    ApplicationContext context;

    private static final String NAME_SPACE_URL = "http://inform.gazprom.ru/C/SUIM/REDataExchange";
    private static final String WS_NAME = "REAttrDataExchangeOutService";
    private static final Logger logger = LoggerFactory.getLogger(MSUIMClient2.class.getSimpleName());


    public void init(String serviceUrl, String login, String password) {
        this.serviceUrl = serviceUrl;
        this.login = login;
        this.password = password;
        authenticator(login, password);
    }

    private void authenticator(final String login, final String password) {
        java.net.Authenticator.setDefault(new java.net.Authenticator() {

            @Override
            protected java.net.PasswordAuthentication getPasswordAuthentication() {
                return new java.net.PasswordAuthentication(login, password.toCharArray());
            }
        });
    }

    public Map<String, Object> isAllowedWebService() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(this.serviceUrl).openConnection();
            connection.setRequestMethod("GET");
            connection.getInputStream();
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                return replyHelper.failed("Server returned error: " + responseCode + "Message: " + connection.getResponseMessage());
            }
        } catch (Exception e) {
            return replyHelper.failed("Failed to connect to URL: " + this.serviceUrl + " Exception: " + e.toString());
        }
        return replyHelper.succeed();
    }

    public Map<String, Object> doWork() {
        logger.info("Start Do Work");
        try {
            REAttrDataExchangeOut reAttrDataExchangeOut = getService(this.serviceUrl, this.login, this.password);
            List<REDataExchangeAttrFile> attrFiles = addAttachment.getAttrFiles();
            logger.info("AttrFiles size = " + attrFiles.size());
            for (REDataExchangeAttrFile attrFile : attrFiles) {
                logger.info("AttrFile  = " + attrFile.getFILENAME());
                message.setAttrFile(attrFile);
                logger.info("AttrFile've edded addedREDataExchangeAttrECD");
                reAttrDataExchangeOut.reAttrDataExchangeOut(message);
            }
        } catch (MalformedURLException e) {
            return replyHelper.failed("Error in doWork method. Exception: " + e.toString());
        } catch (Exception e) {
            return replyHelper.failed(("Error in doWork method. Exception: " + e));
        }
        return replyHelper.succeed();
    }

    private REAttrDataExchangeOut getService(String url, String login, String pass) throws MalformedURLException {
        logger.info("Start Get Service");
        URL wsdlUrl = new URL(url);
        QName qName = new QName(NAME_SPACE_URL, WS_NAME);
        Service service = Service.create(wsdlUrl, qName);
        REAttrDataExchangeOut reAttrDataExchangeOut = service.getPort(REAttrDataExchangeOut.class);

        BindingProvider bp = (BindingProvider) reAttrDataExchangeOut;

        Map<String, Object> requestContext = bp.getRequestContext();

        requestContext.put(BindingProviderProperties.CONNECT_TIMEOUT, 5000);
        requestContext.put(BindingProviderProperties.REQUEST_TIMEOUT, 25000);
        requestContext.put(BindingProvider.USERNAME_PROPERTY, login);
        requestContext.put(BindingProvider.PASSWORD_PROPERTY, pass);
        requestContext.put("chunks", addAttachment.getChunks().size());

        SOAPBinding binding = (SOAPBinding) bp.getBinding();
        List<Handler> handlerChain = binding.getHandlerChain();
        mh.setChunks(addAttachment.getChunks());
        mh.setMimeType(addAttachment.getMimeType());
        mh.setContentId(addAttachment.getContentId());
        handlerChain.add(mh);
        binding.setHandlerChain(handlerChain);
        return reAttrDataExchangeOut;
    }

    public REDataExchangeAttrECD getMessage() {
        return message;
    }

    public void setMessage(REDataExchangeAttrECD message) {
        this.message = message;
    }

    public ReplyHelper getReplyHelper() {
        return replyHelper;
    }

    public void setReplyHelper(ReplyHelper replyHelper) {
        this.replyHelper = replyHelper;
    }
}
