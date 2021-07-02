package com.example.moodtracker.controller;


import com.example.moodtracker.model.MoodEntry;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/moodEntry")
public interface MoodOperations {

    @GetMapping
    List<MoodEntry> getAll();

    @PostMapping
    MoodEntry addEntry(MoodEntry newMoodEntry);

    @GetMapping("/{id}")
    MoodEntry findById(@PathVariable Long id);

    @PutMapping("/{id}")
    MoodEntry updateEntry(@PathVariable Long id, MoodEntry newMoodEntry);

    @GetMapping("/findByMood")
    List<MoodEntry> findByMood();

    @GetMapping("/findByTags")
    List<MoodEntry> findByTags();
}
