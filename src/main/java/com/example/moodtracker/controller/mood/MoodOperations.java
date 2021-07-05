package com.example.moodtracker.controller.mood;


import com.example.moodtracker.model.mood.BaseMood;
import com.example.moodtracker.model.mood.MoodEntry;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
public interface MoodOperations {

    //GET moodEntry
    @GetMapping("/moodEntry")
    ResponseEntity<?> getAll();

    //POST moodEntry
    @PostMapping("/moodEntry")
    ResponseEntity addEntry(@RequestBody MoodEntry newMoodEntry);

    //GET moodEntry/id
    @GetMapping("/moodEntry/{id}")
    ResponseEntity<?> findById(@PathVariable Long id);

    @PutMapping("/moodEntry/{id}")
    ResponseEntity updateEntry(@PathVariable Long id, @RequestBody MoodEntry newMoodEntry);

    //GET search/mood/find
    @GetMapping("/search/mood")
    ResponseEntity findByMood(@RequestParam("find") BaseMood moodToFind);

    //GET search/tag/find
    @GetMapping("/search/tags")
    ResponseEntity<?> findByTagsIn(@RequestParam("find") List<String> keywords);
}
