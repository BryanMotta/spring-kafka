package com.bryan.motta.spring.kafka.services;

import com.bryan.motta.spring.kafka.annotations.Loggable;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class ConsumerService {

    @Loggable
    @KafkaListener(topics = "kafkaTopic", groupId = "group_id")
    public void consume(String message) {
    }

    @KafkaListener(topics = "logs", groupId = "group_id")
    public void consumeLogs(String message) {
        System.out.println(message);
    }
}
