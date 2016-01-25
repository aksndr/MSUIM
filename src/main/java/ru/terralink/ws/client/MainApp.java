package ru.terralink.ws.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.terralink.ws.model.REDataExchangeAttrECD;

import java.util.Map;

/**
 * Created by AzarovD on 25.01.2016.
 */
public class MainApp {

    private MSUIMClient2 msuimClient;
    private ReplyHelper replyHelper;
    private AddAttachment addAttachment;
    private AddSection addSection;

    public Map<String, Object> init(String serviceUrl, String login, String password){
        try {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/terralink/spring-config.xml");
            msuimClient = (MSUIMClient2) applicationContext.getBean("msuimClient2");
            msuimClient.init(serviceUrl, login, password);
            replyHelper = (ReplyHelper) applicationContext.getBean("replyHeader");
            addAttachment = (AddAttachment)applicationContext.getBean("addAttachment");
            addSection = (AddSection) applicationContext.getBean("addSection");
        } catch (Exception e) {
            return replyHelper.failed("Failed to get ClassPathXmlApplicationContext. Exception: " + e.toString());
        }
        return msuimClient.isAllowedWebService();
    }

    public Map<String, Object> addAttachment(int partSize, Map<String, Object> attributes){
        return addAttachment.addAttachment(partSize, attributes);
    }

    public Map<String, Object> addSection(String incomingSectionName, Map<String, Object> incomingAttributes){
        return addSection.addSection(incomingSectionName, incomingAttributes);
    }

    public REDataExchangeAttrECD getMessage() {
        return msuimClient.getMessage();
    }

    public Map<String, Object> doWork(){
        return msuimClient.doWork();
    }

    public AddSection getAddSection() {
        return addSection;
    }

    public void setAddSection(AddSection addSection) {
        this.addSection = addSection;
    }

    public AddAttachment getAddAttachment() {
        return addAttachment;
    }

    public void setAddAttachment(AddAttachment addAttachment) {
        this.addAttachment = addAttachment;
    }
}
