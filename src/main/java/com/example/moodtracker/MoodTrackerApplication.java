package com.example.moodtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MoodTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoodTrackerApplication.class, args);
    }

}
