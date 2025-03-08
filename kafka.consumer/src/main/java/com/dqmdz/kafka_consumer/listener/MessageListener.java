package com.dqmdz.kafka_consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageListener {

    @KafkaListener(topics = "test-topic", groupId = "grupo-consumidores")
    public void listen(String message) {
        log.info("📩 Mensaje recibido: {}", message);
    }

}
