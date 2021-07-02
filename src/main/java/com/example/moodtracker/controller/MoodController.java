package com.example.moodtracker.controller;

import com.example.moodtracker.model.MoodEntry;
import com.example.moodtracker.repository.MoodEntryRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoodController implements MoodOperations{
    private final MoodEntryRepository repository;


    public MoodController(MoodEntryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MoodEntry> getAll() {
        return repository.findAll();
    }

    @Override
    public String addEntry() {
        return null;
    }

    @Override
    public MoodEntry findById() {
        return null;
    }

    @Override
    public String updateEntry() {
        return null;
    }

    @Override
    public List<MoodEntry> findByMood() {
        return null;
    }

    @Override
    public List<MoodEntry> findByTags() {
        return null;
    }
}
