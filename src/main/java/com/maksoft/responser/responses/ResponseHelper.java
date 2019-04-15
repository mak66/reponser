package com.maksoft.responser.responses;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author markw
 */
public class ResponseHelper {

    public static ParameterizedTypeReference<Map<String, Object>> ptr = new ParameterizedTypeReference<Map<String, Object>>() {
    };

    private ResponseHelper() {
    }

    public static <T> T getPayLoad(ResponseEntity<Map<String, Object>> responseEntity, Class c) {
        ObjectMapper mapper = new ObjectMapper();
        Object o = mapper.convertValue(responseEntity.getBody().get("payload"), c);
        return (T) o;
    }
    public static <T> T getPayLoad(ResponseEntity<Map<String, Object>> responseEntity, TypeReference typeReference) {
        ObjectMapper mapper = new ObjectMapper();
        Object o = mapper.convertValue(responseEntity.getBody().get("payload"), typeReference);
        return (T) o;
    }

}
