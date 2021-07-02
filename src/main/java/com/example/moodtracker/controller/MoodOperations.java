package com.example.moodtracker.controller;


import com.example.moodtracker.model.BaseMood;
import com.example.moodtracker.model.MoodEntry;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/moodEntry",consumes = MediaType.APPLICATION_JSON_VALUE)
public interface MoodOperations {

    @GetMapping
    List<MoodEntry> getAll();

    @PostMapping()
    MoodEntry addEntry(@RequestBody MoodEntry newMoodEntry);

    @GetMapping("/{id}")
    MoodEntry findById(@PathVariable Long id);

    @PutMapping("/{id}")
    MoodEntry updateEntry(@PathVariable Long id, MoodEntry newMoodEntry);

    @GetMapping("/search")
    List<MoodEntry> findByMood(@RequestParam("mood") BaseMood moodToFind);

    @GetMapping("/findByTags")
    List<MoodEntry> findByTags();
}
