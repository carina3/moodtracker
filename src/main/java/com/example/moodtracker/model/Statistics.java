package com.example.moodtracker.model;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/statistics", consumes = MediaType.APPLICATION_JSON_VALUE)
public interface Statistics {

}
