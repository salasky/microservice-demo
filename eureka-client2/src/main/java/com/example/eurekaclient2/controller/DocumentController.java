package com.example.eurekaclient2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/document")
public class DocumentController {
    @GetMapping("/test")
    public ResponseEntity<String> getTestDoc(){
        return ResponseEntity.ok("TestDoc");
    }
}
