package com.maksoft.responser.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.maksoft.responser.dtos.Box;
import com.maksoft.responser.responses.ResponseHelper;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author markw
 */
public class BoxControllerTest {
    
    public BoxControllerTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getRedBox method, of class BoxController.
     */
    @Test
    public void testGetRedBox() {
        System.out.println("getRedBox");
        BoxController instance = new BoxController();
        ResponseEntity<Map<String, Object>> expResult = ResponseEntity.ok().body(instance.buildPayload(new Box("1","red","medium")));
        ResponseEntity<Map<String, Object>> result = instance.getRedBox();
        assertEquals(expResult, result);

    }
    @Test
    public void testGetRedBoxOptions() {
        System.out.println("getRedBoxOptions");
        BoxController instance = new BoxController();
        RestTemplate restTemplate = new RestTemplate();
   
        Box expected = new Box("1","red","medium");
        ResponseEntity<Map<String, Object>> result = restTemplate.exchange("http://localhost:8080/redbox", HttpMethod.GET, null,
                ResponseHelper.ptr);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        
        Box actual = ResponseHelper.<Box>getPayLoad(result,Box.class);
        assertEquals(expected, actual);

    }
    @Test
    public void testGetList() {
        System.out.println("getList");
        BoxController instance = new BoxController();
        RestTemplate restTemplate = new RestTemplate();
   
        List<Box> returnedList;
        ResponseEntity<Map<String, Object>> result = restTemplate.exchange("http://localhost:8080/list", HttpMethod.GET, null,
                ResponseHelper.ptr);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        
        List<Box> actual = ResponseHelper.<List<Box>>getPayLoad(result, new TypeReference<List<Box>>(){});
        for (Box b : actual){
            System.out.println("b:"+b);
        }

    }
    
}
