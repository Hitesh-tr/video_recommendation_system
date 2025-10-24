package com.recommendation_system.analytics_service.service;

import com.recommendation_system.analytics_service.model.VideoAnalytics;
import com.recommendation_system.analytics_service.repository.VideoAnalyticsRepository;
import java.util.Map;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsConsumerService {

    private final VideoAnalyticsRepository videoAnalyticsRepo;

    public AnalyticsConsumerService(VideoAnalyticsRepository videoAnalyticsRepo) {
        this.videoAnalyticsRepo = videoAnalyticsRepo;
    }

    @KafkaListener(topics = "video-events", groupId = "analytics-group")
    public void consume(Map<String, Object> event){
        String videoId = (String) event.get("videoId");

        videoAnalyticsRepo.findById(videoId).ifPresentOrElse(
            videoAnalytics -> {
                videoAnalytics.setViewCount(videoAnalytics.getViewCount()+1);
                videoAnalyticsRepo.save(videoAnalytics);
            },
            () -> {
                VideoAnalytics newEntry = new VideoAnalytics();
                newEntry.setVideoId(videoId);
                newEntry.setViewCount(1);
                videoAnalyticsRepo.save(newEntry);
            }
        );

        System.out.println("Updated analytivs of the video: " + videoId);
    }
}
