package com.recommendation_system.video_service.controller;

import com.recommendation_system.video_service.model.Video;
import com.recommendation_system.video_service.repository.VideoRepository;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private final VideoRepository videoRepository;

    public VideoController(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @GetMapping
    public List<Video> getAllVideos(){
        return videoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Video getVideoById(@PathVariable Long id){
        return videoRepository.findById(id).orElseThrow(()-> new RuntimeException("Video not found"));
    }

    @PostMapping
    public Video createVideo(@RequestBody Video video){
        return videoRepository.save(video);
    }

    @DeleteMapping("/{id}")
    public String createVideo(@PathVariable Long id){
        videoRepository.deleteById(id);
        return "Video Deleted";
    }
}
