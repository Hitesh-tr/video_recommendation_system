package com.recommendation_system.analytics_service.controller;

import com.recommendation_system.analytics_service.model.VideoAnalytics;
import com.recommendation_system.analytics_service.repository.VideoAnalyticsRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final VideoAnalyticsRepository videoAnalyticsRepo;

    public AnalyticsController(VideoAnalyticsRepository videoAnalyticsRepo) {
        this.videoAnalyticsRepo = videoAnalyticsRepo;
    }

    @GetMapping("/trending")
    public List<VideoAnalytics> getTrendingVideo(){
        return videoAnalyticsRepo.findAll()
            .stream()
            .sorted((a,b) -> Long.compare(b.getViewCount(), a.getViewCount()))
            .limit(10)
            .toList();
    }
}
