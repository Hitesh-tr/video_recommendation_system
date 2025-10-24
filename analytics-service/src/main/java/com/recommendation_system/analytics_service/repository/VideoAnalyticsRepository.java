package com.recommendation_system.analytics_service.repository;

import com.recommendation_system.analytics_service.model.VideoAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoAnalyticsRepository extends JpaRepository<VideoAnalytics,String> {
}
