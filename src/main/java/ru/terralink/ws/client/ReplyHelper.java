package ru.terralink.ws.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AzarovD on 22.01.2016.
 */

public class ReplyHelper {

    private static final Logger logger = LoggerFactory.getLogger(ReplyHelper.class.getSimpleName());

    public Map<String, Object> succeed() {
        Map<String, Object> result = new HashMap<>();
        result.put("ok", true);
        return result;
    }

    public Map<String, Object> succeed(Object value) {
        Map<String, Object> result = new HashMap<>();
        result.put("ok", true);
        result.put("value", value);
        return result;
    }

    public Map<String, Object> failed(String errMsg) {
        logger.error(errMsg);
        Map<String, Object> result = new HashMap<>();
        result.put("ok", false);
        result.put("errMsg", errMsg);
        return result;
    }
}
