package com.maksoft.responser.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maksoft.responser.dtos.Box;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author markw
 */
@RestController
public class BoxController {
    ObjectMapper mapper = new ObjectMapper();
    
    @GetMapping("/redbox")
    public ResponseEntity<Map<String,Object>> getRedBox(){
        
        return ResponseEntity.ok().body(this.<Box>buildPayload(new Box("1","red","medium")));
    }
    @GetMapping("/list")
    public ResponseEntity<Map<String,Object>> getList(){
        
        List<Box> list = new ArrayList<>();
        list.add(new Box("1","red","medium"));
        list.add(new Box("2","blue","medium"));
        list.add(new Box("3","green","medium"));
        
        return ResponseEntity.ok().body(this.buildPayload(list));
    }
    
    public Map<String,Object> buildPayload(Object payload){
        Map<String,Object> response = new HashMap<>();
        response.put("payload", payload);
        response.put("status", "OK");
        
        return response;
    }
}
