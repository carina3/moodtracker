package com.example.moodtracker.controller.mood;


import com.example.moodtracker.model.mood.BaseMood;
import com.example.moodtracker.model.mood.MoodEntry;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/api", consumes = MediaType.APPLICATION_JSON_VALUE)
public interface MoodOperations {

    //GET moodEntry
    @GetMapping("/mood-entries")
    ResponseEntity<?> getAll();

    //POST moodEntry
    @PostMapping("/mood-entries")
    ResponseEntity addEntry(@RequestBody MoodEntry newMoodEntry);

    //GET moodEntry/id
    @GetMapping("/mood-entries/{id}")
    ResponseEntity<?> findById(@PathVariable Long id);

    @PutMapping("/mood-entries/{id}")
    ResponseEntity updateEntry(@PathVariable Long id, @RequestBody MoodEntry newMoodEntry);

    //GET search/mood/find
    @GetMapping("/search/mood")
    ResponseEntity findByMood(@RequestParam("find") BaseMood moodToFind);

    //GET search/tag/find
    @GetMapping("/search/tags")
    ResponseEntity<?> findByTagsIn(@RequestParam("find") List<String> keywords);
}
