package ru.salavat.eurekaclient2.mq;

import com.salavat.dto.DocumentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import ru.salavat.eurekaclient2.service.DocumentService;

/**
 * Класс обработки сообщений из DocumentBinding.INPUT_CHANNEL
 */
@EnableBinding({DocumentBinding.class})
@Component
public class MessageConsumer {

    @Autowired
    private DocumentService documentService;

    //метод вызывается автоматически как только сообщение появляется в INPUT_CHANNEL
    @StreamListener(target = DocumentBinding.INPUT_CHANNEL)
    public void saveDocument(DocumentDTO documentDTO){
        documentService.save(documentDTO);
    }
}
