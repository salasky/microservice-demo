package ru.salavat.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.salavat.eurekaclient.mq.MessageProducer;

@RestController
@RequestMapping("/operatorDocument")
public class OperatorDocumentController {

    @Autowired
    private MessageProducer messageProducer;
    @GetMapping("/generate")
    public void getTestDocument(){
        messageProducer.generateDocument();
    }
}
