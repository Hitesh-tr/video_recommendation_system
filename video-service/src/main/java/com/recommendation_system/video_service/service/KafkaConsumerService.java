package com.recommendation_system.video_service.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "video-events", groupId = "video-service-group")
    public void consume(Object message) {
        System.out.println("Received event from Kafka: " + message);
        // TODO: update DB or trigger logic
    }
}
