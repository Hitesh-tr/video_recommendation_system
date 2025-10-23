package com.recommendation_system.user_service.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private static final String TOPIC = "video-events";
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(Object event) {
        kafkaTemplate.send(TOPIC, event);
        System.out.println("✅ Sent event to Kafka topic [" + TOPIC + "]: " + event);
    }
}
