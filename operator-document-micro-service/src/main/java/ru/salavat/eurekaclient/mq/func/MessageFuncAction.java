package ru.salavat.eurekaclient.mq.func;

import com.salavat.dto.DocumentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

import java.util.Random;
import java.util.UUID;

@Service
/**
 * Класс для отправки сообщения с помощью функционального кода - по требованию (только после)
 */
public class MessageFuncAction {

    /**
     * Каналы для обмена сообщениями
     */
    @Autowired
    private MessageFunc messageFunc;

    public void sendNewDocMessage(){
        DocumentDTO documentDTO = new DocumentDTO();
        Random random = new Random();
        documentDTO.setContent(random.nextLong()+ "Contents");
        documentDTO.setSignatureId(UUID.fromString("4868d938-57f8-42b8-8115-4bccaeb5b899"));
        //добовляем в слушатель новое сообщение
        messageFunc.getInnerBus().emitNext(MessageBuilder.withPayload(documentDTO).build(), Sinks.EmitFailureHandler.FAIL_FAST);
        System.out.println("Сообщение отправлено в буфер");
    }

    public MessageFunc getMessageFunc() {
        return messageFunc;
    }
}


/*public interface OperatorDocumentBinding {
    String OUTPUT_CHANNEL = "operatorDocumentOutputChannel";
    @Output(OUTPUT_CHANNEL)
    MessageChannel operatorDocumentOutputChannel();
}*/
