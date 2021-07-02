package com.example.moodtracker.controller;

import com.example.moodtracker.exception.MoodEntryNotFoundException;
import com.example.moodtracker.model.MoodEntry;
import com.example.moodtracker.repository.MoodEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoodController implements MoodOperations{
    @Autowired
    private final MoodEntryRepository repository;

    public MoodController(MoodEntryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MoodEntry> getAll() {
        return repository.findAll();
    }

    @Override
    public MoodEntry addEntry(@RequestBody MoodEntry newMoodEntry) {
        return repository.save(newMoodEntry);
    }

    @Override
    public MoodEntry findById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MoodEntryNotFoundException(id));
    }

    @Override
    public MoodEntry updateEntry(@PathVariable Long id, MoodEntry updatedMoodEntry) {
        return repository.findById(id)
                .map(moodEntry -> {
                    moodEntry.setMood(updatedMoodEntry.getMood());
                    moodEntry.setDescription(updatedMoodEntry.getDescription());
                    moodEntry.setTags(updatedMoodEntry.getTags());
                    return repository.save(moodEntry);
                })
                .orElseGet(() -> {
                    updatedMoodEntry.setId(id);
                    return repository.save(updatedMoodEntry);
                });
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
