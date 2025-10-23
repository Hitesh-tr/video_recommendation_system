package com.recommendation_system.user_service.controller;

import com.recommendation_system.user_service.service.KafkaProducerService;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {
    private final KafkaProducerService kafkaProducerService;

    public EventController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/publish")
    public String publishEvent(@RequestBody Map<String, Object> payload) {
        kafkaProducerService.sendEvent(payload);
        return "Event published successfully!";
    }
}
