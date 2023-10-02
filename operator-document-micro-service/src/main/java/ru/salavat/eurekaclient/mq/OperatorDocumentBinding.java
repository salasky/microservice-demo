package ru.salavat.eurekaclient.mq;

import org.springframework.messaging.MessageChannel;
import org.springframework.cloud.stream.annotation.Output;

/**
 * Интерфейс для создания каналов
 */
public interface OperatorDocumentBinding {
    String OUTPUT_CHANNEL = "operatorDocumentOutputChannel";
    @Output(OUTPUT_CHANNEL)
    MessageChannel operatorDocumentOutputChannel();
}
