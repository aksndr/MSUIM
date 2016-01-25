package ru.terralink.ws.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import ru.terralink.common.Utils;
import ru.terralink.ws.model.REDataExchangeAttrECD;

import javax.xml.datatype.DatatypeConfigurationException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import static ru.terralink.common.TransformationNameHelper.transformationAttributeKey;
import static ru.terralink.common.TransformationNameHelper.transformationSectionName;

/**
 * Created by AzarovD on 22.01.2016.
 */

public class AddSection {

    @Autowired
    private ReplyHelper replyHelper;
    @Autowired
    private REDataExchangeAttrECD message;
    @Autowired
    private ApplicationContext context;

    private static final Logger logger = LoggerFactory.getLogger(AddSection.class.getSimpleName());

    public Map<String, Object> addSection(String incomingSectionName, Map<String, Object> incomingAttributes) {

        Map<String, Object> invalidData = validateIncomingData(incomingSectionName, incomingAttributes);
        if (invalidData != null) {
            return invalidData;
        }

        Map<String, String> attributes = transformationAttributeKey(incomingAttributes);
        String sectionName = transformationSectionName(incomingSectionName);
        try {

            Field field = message.getClass().getDeclaredField(sectionName);
            logger.info("Current Field " + message.getClass().getSimpleName() + "." + sectionName);
            field.setAccessible(true);
            String fieldName = field.getName();
            String fieldType = field.getType().getName();
            logger.info("Current FieldType " + fieldType);

            Object section = context.getBean(sectionName);
            logger.info("Current Section: " + sectionName);

            if (fieldType.equals("java.util.List")) {
                String methodName = "set" + fieldName.toUpperCase();
                Method method = message.getClass().getMethod(methodName, Object.class);
                method.invoke(message, section);
            } else {
                field.set(message, section);
            }
            logger.info("Get fields from current section:\n");
            Field[] fields = section.getClass().getDeclaredFields();
            for (Field sectionField : fields) {
                sectionField.setAccessible(true);
                String sectionFieldName = sectionField.getName().toLowerCase();
                String sectionFieldType = sectionField.getType().getName();
                logger.info("Section Field Name = " + sectionFieldName + " Section Field Type = " + sectionFieldType);
                if (attributes.containsKey(sectionFieldName)) {
                    Object fieldValue = attributes.get(sectionFieldName);
                    if (fieldValue == null) {
                        continue;
                    }
                    logger.info(sectionFieldName + " = " + fieldValue);
                    String stringFieldValue = String.valueOf(fieldValue);
                    if (sectionFieldType.equals("javax.xml.datatype.XMLGregorianCalendar")) {
                        sectionField.set(section, Utils.stringToXMLGregorianCalendar(stringFieldValue));
                    } else if (sectionFieldType.equals("java.lang.String")) {
                        sectionField.set(section, stringFieldValue);
                    } else if (sectionFieldType.equals("java.lang.Boolean")) {
                        sectionField.set(section, Boolean.valueOf(stringFieldValue));
                    } else {
                        sectionField.set(section, fieldValue);
                    }
                    logger.info("Got field: " + sectionFieldName + " field type: " + sectionFieldType + " value: " + stringFieldValue + "\n");
                } else {
                    logger.error("In the incoming attributes no field " + sectionFieldName);
                }
            }

        } catch (IllegalArgumentException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException | ParseException e) {
            return replyHelper.failed("Error in addSection method. Exception: " + e.toString());
        } catch (DatatypeConfigurationException e) {
            return replyHelper.failed("Faild convert date format " + e.toString());
        }
        return replyHelper.succeed();
    }

    private Map<String, Object> validateIncomingData(String incomingSectionName, Map<String, Object> incomingAttributes) {
        if (StringUtils.isEmpty(incomingSectionName)) {
            return replyHelper.failed("Section name were undefined");
        }
        if (CollectionUtils.isEmpty(incomingAttributes)) {
            return replyHelper.failed("Attributes is undefined");
        }
        return null;
    }
}
