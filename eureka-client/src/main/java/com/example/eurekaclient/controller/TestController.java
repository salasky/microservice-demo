package com.example.eurekaclient.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class TestController {
    @GetMapping("/test")
    public ResponseEntity<String> getTestString(){
        return ResponseEntity.ok("Test");
    }
}
