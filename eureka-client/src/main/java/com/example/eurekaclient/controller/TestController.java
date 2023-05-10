package com.example.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class TestController {

    @Value("${eureka.instance.instance-id}")
    private String id;

    @Value("${tempvar}")
    private String tempvar;

    @GetMapping("/test")
    public ResponseEntity<String> getTestString(){
        return ResponseEntity.ok(id+" "+tempvar);
    }
}
