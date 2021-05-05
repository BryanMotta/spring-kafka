package com.bryan.motta.spring.kafka.services;

import com.bryan.motta.spring.kafka.annotations.Loggable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class ProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC = "kafkaTopic";

    public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Loggable
    public void sendMessage(String message) {

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC, message);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
            }
        });
    }
}
