package com.recommendation_system_backend.video_platform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/health")
    public String health(){
        return "Ok";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello from Video Platform";
    }
}
