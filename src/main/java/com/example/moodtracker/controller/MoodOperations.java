package com.example.moodtracker.controller;


import com.example.moodtracker.model.BaseMood;
import com.example.moodtracker.model.MoodEntry;
import com.example.moodtracker.model.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
public interface MoodOperations {

    //GET moodEntry
    @GetMapping("/moodEntry")
    List<MoodEntry> getAll();

    //POST moodEntry
    @PostMapping("/moodEntry")
    MoodEntry addEntry(@RequestBody MoodEntry newMoodEntry);

    //GET moodEntry/id
    @GetMapping("/moodEntry/{id}")
    MoodEntry findById(@PathVariable Long id);

    @PutMapping("/moodEntry/{id}")
    MoodEntry updateEntry(@PathVariable Long id, MoodEntry newMoodEntry);

    //GET search/mood/find
    @GetMapping("/search/mood")
    List<MoodEntry> findByMood(@RequestParam("find") BaseMood moodToFind);

    //GET search/tag/find
    @GetMapping("/search/tags")
    List<MoodEntry> findByTagsIn(@RequestParam("find") List<String> keywords);
}
