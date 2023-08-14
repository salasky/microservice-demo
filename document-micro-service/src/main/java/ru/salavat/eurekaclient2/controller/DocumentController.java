package ru.salavat.eurekaclient2.controller;

import com.salavat.entity.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @GetMapping("/test")
    public ResponseEntity<String> getTestString(){
        Document document = new Document();
        document.setId(UUID.randomUUID());
        document.setContent("Content");
        document.setAttorneyId(UUID.randomUUID());
        return ResponseEntity.ok("Document");
    }
}
