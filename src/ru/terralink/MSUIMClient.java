package ru.terralink;

import org.joda.time.LocalDate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.terralink.common.Utils;
import ru.terralink.model.REDataExchangeAttrECD;
import ru.terralink.model.REDataExchangeAttrFile;

import javax.xml.datatype.DatatypeConfigurationException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Created by Arzamastsev on 14.12.2015.

public class MSUIMClient {

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

    public Map<String, Object> init(){
        try {
            context = new ClassPathXmlApplicationContext("ru/terralink/spring-config.xml");
        } catch (Exception be) {
            logger.error("Failed to get ClassPathXmlApplicationContext. Error: ", be);
            return failed("Failed to get ClassPathXmlApplicationContext. Error: " + be.toString());
        }
        return succeed();
    }

    /**public Map<String, Object> addSection(String sectionName, Map<String, Object> attributes){
        try {

            if (validateAddSectionParams(sectionName, attributes)) return result;

            Object section = context.getBean(sectionName);
            Field[] fields = section.getClass().getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                String fieldType = field.getType().getName();

                if (attributes.containsKey(fieldName)){
                    Object fieldValue = attributes.get(fieldName);
                    String stringValue = String.valueOf(fieldValue);
                    if (fieldType.equals("org.joda.time.LocalDate")) {
                        field.set(section, Utils.getLocalDate(stringValue));
                    } else if (fieldType.equals("java.lang.String")) {
                        field.set(section, stringValue);
                    } else {
                        field.set(section, fieldValue);
                    }
                }
                logger.info("Got field: " + fieldName.toUpperCase() + " field type: " + fieldType);
            }
            sections.put(sectionName,section);
        } catch (IllegalAccessException | ParseException e) {
            logger.error("Error in buildMessage method. ", e);
            return failed(e.getMessage());
        }
        return succeed();
    }

    public Map<String, Object> buildMessage(){
        try {
            Field[] fields = message.getClass().getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                String fieldType = field.getType().getName();

                if (sections.containsKey(fieldName)){
                    Object section = sections.get(fieldName);
                    field.set(message, section);
                }

                logger.info("Got field: " + fieldName.toUpperCase() + " field type: " + fieldType);
            }
        } catch (IllegalAccessException e) {
            logger.error("Error in buildMessage method. ", e);
            return failed(e.getMessage());
        }
        return succeed();
    }*/

    public Map<String, Object> addSection(String sectionName, Map<String, Object> attributes) {
        if (validateAddSectionParams(sectionName, attributes)) return result;

        try {
            Field field = message.getClass().getDeclaredField(sectionName);
            field.setAccessible(true);
            String fieldName = field.getName();
            String fieldType = field.getType().getName();

            Object section = context.getBean(sectionName);

            if (fieldType.equals("java.util.List")){
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

                if (attributes.containsKey(sectionFieldName)){
                    Object fieldValue = attributes.get(sectionFieldName);
                    String stringValue = String.valueOf(fieldValue);
                    if (sectionFieldType.equals("org.joda.time.LocalDate")) {
                        sectionField.set(section, Utils.getLocalDate(stringValue));
                    } else if (sectionFieldType.equals("java.lang.String")) {
                        sectionField.set(section, stringValue);
                    } else {
                        sectionField.set(section, fieldValue);
                    }
                }
                logger.info("Got field: " + sectionFieldName.toUpperCase() + " field type: " + sectionFieldType);
            }

        } catch (IllegalArgumentException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException | ParseException e) {
            String errMsg = "Error in buildMessage method. Exception: "+ e.toString();
            logger.error(errMsg);
            return failed(errMsg);
        }
        return succeed();
    }

    public Map<String, Object> addAttachment(Map<String, Object> attributes){
        logger.info("Started addAttachment");
        if (attributes != null && attributes.containsKey("CONTENT")) {
            try {
                byte[] content = (byte[]) attributes.get("CONTENT");
                logger.info("Attachment size: " + content.length);
                if (content != null) {

                    String File_ID = attributes.containsKey("File_ID") ? String.valueOf(attributes.get("File_ID")) : "";
                    String FILE_NAME = attributes.containsKey("FILE_NAME") ? String.valueOf(attributes.get("FILE_NAME")) : "";
                    Integer NOMER = attributes.containsKey("NOMER") ? (Integer)attributes.get("NOMER") : 0;
                    String USERS = attributes.containsKey("USERS") ? String.valueOf(attributes.get("USERS")) : "";
                    String USERSTXT = attributes.containsKey("USERSTXT") ? String.valueOf(attributes.get("USERSTXT")) : "";
                    LocalDate DATUM = attributes.containsKey("DATUM") ? Utils.getLocalDate(String.valueOf(attributes.get("DATUM"))) : null;
                    Boolean Delete = attributes.containsKey("Delete") ? (Boolean)attributes.get("Delete") : false;
                    Integer chunkSize = attributes.containsKey("chunkSize") ? (Integer)attributes.get("chunkSize") : 5;

                    String totalHash = Utils.getSha1Hash(content);
                    List<byte[]> chunks = Utils.splitContent(content, chunkSize);
                    int currentPartNum = 1;
                    int totalPartsNum = chunks.size();
                    for (byte[] chunk : chunks) {
                        String chunkHash = Utils.getSha1Hash(chunk);

                        REDataExchangeAttrFile AttrFile = new REDataExchangeAttrFile();
                        AttrFile.setFileID(File_ID);
                        AttrFile.setFILENAME(FILE_NAME);
                        AttrFile.setNOMER(NOMER);
                        AttrFile.setUSERS(USERS);
                        AttrFile.setUSERSTXT(USERSTXT);
                        AttrFile.setDATUM(DATUM);
                        AttrFile.setDelete(Delete);
                        AttrFile.setCurrentPart(currentPartNum);
                        AttrFile.setCurrentHash(chunkHash);
                        AttrFile.setAllParts(totalPartsNum);
                        AttrFile.setAllHash(totalHash);
                        AttrFile.setContent(chunk);

                        message.addAttrFile(AttrFile);
                        currentPartNum++;
                    }
                }
            } catch (Exception e) {
                String errMsg = "Error in addAttachment method. Exception: "+ e.toString();
                logger.error(errMsg);
                return failed(errMsg);
            }
        } else {
            logger.warn("Got empty attachment args.");
        }
        logger.info("Finished addAttachment");
        return succeed();
    }

    public REDataExchangeAttrECD getMessage(){
        return this.message;
    }

    public Map<String, Object> getSections(){
        return sections;
    }

    private boolean validateAddSectionParams(String sectionName, Map<String, Object> attributes) {
        if (sectionName == null || "".equals(sectionName)){
            result = failed("Section name were undefined");
            return true;
        }
        if (attributes == null || Collections.EMPTY_MAP.equals(attributes) ){
            result = failed("Attributes is undefined");
            return true;
        }
        return false;
    }

    private static Map<String, Object> succeed(){
        Map<String, Object> result = new HashMap<>();
        result.put("ok", true);
        return result;
    }

    private static Map<String, Object> succeed(Object value){
        Map<String, Object> result = new HashMap<>();
        result.put("ok", true);
        result.put("value", value);
        return result;
    }

    private static Map<String, Object> failed(String errMsg){
        Map<String, Object> result = new HashMap<>();
        result.put("ok", false);
        result.put("errMsg", errMsg);
        return result;
    }

}
