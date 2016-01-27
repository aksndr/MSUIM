package ru.terralink.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by AzarovD on 21.01.2016.
 */
public class TransformationNameHelper {

    private static final Logger logger = LoggerFactory.getLogger(TransformationNameHelper.class.getSimpleName());

    public static Map<String, String> transformationAttributeKey(Map<String, Object> incomingAttributes) {
        Map<String, String> attributes = new HashMap<>();
        Iterator<Map.Entry<String, Object>> iterator = incomingAttributes.entrySet().iterator();
        logger.info("Tranformation attributes name (remove '_' and to lower case): ");
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            String value = entry.getValue() != null ? String.valueOf(entry.getValue()) : null;
            String keyValue = transformationStringValue(entry.getKey());
            attributes.put(keyValue, value);
            iterator.remove();
            logger.info("Attribute " + keyValue + " =  " + value);
        }
        return attributes;
    }

    public static String transformationSectionName(String sectionName){
        if(sectionName.equals("attrFile")){
            return sectionName;
        }
        return transformationStringValue(sectionName);
    }

    private static String transformationStringValue(String str){
        return str.replaceAll("_", "").toLowerCase();
    }
}
