package ru.salavat.eurekaclient.mq;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageChannel;

/**
 * Интерфейс для создания канало
 */
public interface OperatorDocumentBinding {
    String OUTPUT_CHANNEL = "operatorDocumentOutputChannel";
    @OutPut(OUTPUT_CHANNEL)
    MessageChannel operatorDocumentOutputChannel();
}
