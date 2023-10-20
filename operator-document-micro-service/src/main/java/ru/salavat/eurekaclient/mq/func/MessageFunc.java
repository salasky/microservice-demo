package ru.salavat.eurekaclient.mq.func;


import com.salavat.dto.DocumentDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.util.concurrent.Queues;

import java.util.function.Supplier;

/**
 * Конфигурационный клас для описания всех каналы с помощью функциональных методов
 */
@Configuration
public class MessageFunc {

    //для того чтобы считать данные по требованию(а не по состоянию) - создаем поток, откуда данные будут отправляться уже в канал SCS
    //будем использовать внутреннюю шину, из которой будут отправляться сообщения в канал SCS (по требованию)
    //на внутреннюю шину подписывается Supplier
    private Sinks.Many<Message<DocumentDTO>> innerBus = Sinks.many().multicast().onBackpressureBuffer(Queues.SMALL_BUFFER_SIZE, false);

    //отправляет в канал документ, чтобы сохранить его в другом микросервисе
    //название метода должно совпадать с настройками definition и bindings в файлах настройки
    @Bean
    public Supplier<Flux<Message<DocumentDTO>>> newDocumentActionProduce(){
        return () -> innerBus.asFlux();
    }

    public Sinks.Many<Message<DocumentDTO>> getInnerBus() {
        return innerBus;
    }
}

/*
@Component
@EnableBinding(OperatorDocumentBinding.class)
public class MessageProducers {

    @Autowired
    private OperatorDocumentBinding operatorDocumentBinding; // содержит все описанные каналы


    // отправка сообщения
    public void generateDocument() {
        DocumentDTO documentDTO = new DocumentDTO();
        Random random = new Random();
        documentDTO.setContent(random.nextLong()+ "Contents");
        documentDTO.setSignatureId(UUID.fromString("4868d938-57f8-42b8-8115-4bccaeb5b899"));
        // контейнер для добавления данных и headers
        Message message = MessageBuilder.withPayload(documentDTO).build();
        operatorDocumentBinding.operatorDocumentOutputChannel().send(message); // выбираем канал и отправляем сообщение
    }
}*/
