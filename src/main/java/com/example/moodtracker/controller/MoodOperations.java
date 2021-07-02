package com.example.moodtracker.controller;


import com.example.moodtracker.model.MoodEntry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("/moodEntry")
public interface MoodOperations {

    @GetMapping
    List<MoodEntry> getAll();

    @PostMapping
    String addEntry();

    @GetMapping("/{entryId}")
    MoodEntry findById();

    @PutMapping("/{entryId}")
    String updateEntry();

    @GetMapping("/findByMood")
    List<MoodEntry> findByMood();

    @GetMapping("/findByTags")
    List<MoodEntry> findByTags();
}
