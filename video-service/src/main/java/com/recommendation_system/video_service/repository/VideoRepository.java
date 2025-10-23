package com.recommendation_system.video_service.repository;

import com.recommendation_system.video_service.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
