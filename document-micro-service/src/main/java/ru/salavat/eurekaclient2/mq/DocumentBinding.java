package ru.salavat.eurekaclient2.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;


public interface DocumentBinding {
    String INPUT_CHANNEL = "documentInputChannel";

    @Input(INPUT_CHANNEL)
    MessageChannel documentInputChannel();
}
