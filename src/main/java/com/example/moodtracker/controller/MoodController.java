package com.example.moodtracker.controller;

import com.example.moodtracker.exception.MoodEntryNotFoundException;
import com.example.moodtracker.model.BaseMood;
import com.example.moodtracker.model.MoodEntry;
import com.example.moodtracker.model.Tag;
import com.example.moodtracker.repository.MoodEntryRepository;
import com.example.moodtracker.repository.TagRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class MoodController implements MoodOperations {
    private final Logger logger = LoggerFactory.getLogger(MoodController.class);

    private final MoodEntryRepository moodEntryRepository;
    private final TagRepository tagRepository;

    public MoodController(MoodEntryRepository moodEntryRepository, TagRepository tagRepository) {
        this.moodEntryRepository = moodEntryRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public List<MoodEntry> getAll() {
        return moodEntryRepository.findAll();
    }

    @Override
    public MoodEntry addEntry(MoodEntry newMoodEntry) {
        Set<Tag> tagsInDatabase = new HashSet<>(tagRepository.findAll());
        Set<Tag> newTags = newMoodEntry.getTags();


        // Get tags that are already in database

        // From these tags, get id

        // Assign old and new tags to moodentry, but not duplicates, but how?


        tagRepository.saveAll(newMoodEntry.getTags());
        newMoodEntry.setCreationTime(Instant.now());
        return moodEntryRepository.save(newMoodEntry);
    }


    @Override
    public MoodEntry findById(Long id) {
        return moodEntryRepository.findById(id)
                .orElseThrow(() -> new MoodEntryNotFoundException(id));
    }

    @Override
    public MoodEntry updateEntry(Long id, MoodEntry updatedMoodEntry) {
        return moodEntryRepository.findById(id)
                .map(moodEntry -> {
                    moodEntry.setMood(updatedMoodEntry.getMood());
                    moodEntry.setDescription(updatedMoodEntry.getDescription());
                    moodEntry.setTags(updatedMoodEntry.getTags());
                    return moodEntryRepository.save(moodEntry);
                })
                .orElseGet(() -> {
                    updatedMoodEntry.setId(id);
                    return moodEntryRepository.save(updatedMoodEntry);
                });
    }

    @Override
    public List<MoodEntry> findByMood(BaseMood moodToFind) {
        return moodEntryRepository.findByMood(moodToFind);
    }

    @Override
    public List<MoodEntry> findByTagsIn(List<String> keywords) {
        return moodEntryRepository.findByTagsIn(keywords);
    }
}
