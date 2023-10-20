package ru.salavat.eurekaclient2.mq.func;

import com.salavat.dto.DocumentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import ru.salavat.eurekaclient2.service.DocumentService;

import java.util.function.Consumer;

//при запуске считываем бины и создаем каналы
@Configuration
public class MessageFunc {
    // для заполения тестовых данных
    @Autowired
    private DocumentService documentService;

    @Bean
    public Consumer<Message<DocumentDTO>> newDocumentConsume(){
        return message -> documentService.save(message.getPayload());
    }
}
/*public interface DocumentBinding {
    String INPUT_CHANNEL = "documentInputChannel";

    @Input(INPUT_CHANNEL)
    MessageChannel documentInputChannel();
}*/

/*@EnableBinding({DocumentBinding.class})
@Component
public class MessageConsumers {

    @Autowired
    private DocumentService documentService;

    //метод вызывается автоматически как только сообщение появляется в INPUT_CHANNEL
    @StreamListener(target = DocumentBinding.INPUT_CHANNEL)
    public void saveDocument(DocumentDTO documentDTO){
        Random random = new Random();
        boolean flag = random.nextBoolean();
        if(flag){
            documentService.save(documentDTO);
        } else {
            throw new RuntimeException("Test dlq");
        }

    }
}*/
