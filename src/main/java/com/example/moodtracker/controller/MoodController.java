package com.example.moodtracker.controller;

import com.example.moodtracker.model.BaseMood;
import com.example.moodtracker.model.MoodEntry;
import com.example.moodtracker.service.MoodService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoodController implements MoodOperations {
    private final Logger logger = LoggerFactory.getLogger(MoodController.class);

    private final MoodService service;

    public MoodController(MoodService service) {
        this.service = service;
    }

    @Override
    public List<MoodEntry> getAll() {
        return service.fetchAllEntries();
    }

    @Override
    public MoodEntry addEntry(MoodEntry newMoodEntry) {
        return service.addEntry(newMoodEntry);
    }

    @Override
    public MoodEntry findById(Long id) {
        return service.findById(id);
    }

    @Override
    public MoodEntry updateEntry(Long id, MoodEntry newMoodEntry) {
        return service.updateEntry(id, newMoodEntry);
    }

    @Override
    public List<MoodEntry> findByMood(BaseMood moodToFind) {
        return service.findByMood(moodToFind);
    }

    @Override
    public List<MoodEntry> findByTagsIn(List<String> keywords) {
        return service.findByTagsIn(keywords);
    }
}
