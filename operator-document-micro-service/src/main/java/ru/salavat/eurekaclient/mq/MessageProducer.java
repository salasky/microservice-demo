package ru.salavat.eurekaclient.mq;

import com.salavat.dto.DocumentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
@EnableBinding(OperatorDocumentBinding.class)
public class MessageProducer {

    @Autowired
    private OperatorDocumentBinding operatorDocumentBinding; // содержит все описанные каналы


    // отправка сообщения
    public void generateDocument() {
        DocumentDTO documentDTO = new DocumentDTO();
        Random random = new Random();
        documentDTO.setContent(String.valueOf(random.nextLong())+ "Contents");
        documentDTO.setSignatureId(UUID.fromString("4868d938-57f8-42b8-8115-4bccaeb5b899"));
        // контейнер для добавления данных и headers
        Message message = MessageBuilder.withPayload(documentDTO).build();
        operatorDocumentBinding.operatorDocumentOutputChannel().send(message); // выбираем канал и отправляем сообщение
    }
}
