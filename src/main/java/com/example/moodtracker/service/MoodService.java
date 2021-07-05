package com.example.moodtracker.service;

import com.example.moodtracker.exception.MoodEntryNotFoundException;
import com.example.moodtracker.model.BaseMood;
import com.example.moodtracker.model.MoodEntry;
import com.example.moodtracker.model.Tag;
import com.example.moodtracker.repository.MoodEntryRepository;
import com.example.moodtracker.repository.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class MoodService {
    private final Logger logger = LoggerFactory.getLogger(MoodService.class);

    private final MoodEntryRepository moodEntryRepository;
    private final TagRepository tagRepository;
    private final long ONE_WEEK = 1;
    private final long ONE_MONTH = 1;
    private final long ONE_YEAR = 1;

    public MoodService(MoodEntryRepository moodEntryRepository, TagRepository tagRepository) {
        this.moodEntryRepository = moodEntryRepository;
        this.tagRepository = tagRepository;
    }

    
    public List<MoodEntry> fetchAllEntries() {
        return moodEntryRepository.findAll();
    }

    public MoodEntry addEntry(MoodEntry newMoodEntry) {
        Set<Tag> tagsInDatabase = new HashSet<>(tagRepository.findAll());
        Set<Tag> newTags = newMoodEntry.getTags();


        // Get tags that are already in database

        // From these tags, get id

        // Assign old and new tags to moodentry, but not duplicates, but how?


        tagRepository.saveAll(newMoodEntry.getTags());
        newMoodEntry.setCreationTime(LocalDate.now());
        return moodEntryRepository.save(newMoodEntry);
    }


    
    public MoodEntry findById(Long id) {
        return moodEntryRepository.findById(id)
                .orElseThrow(() -> new MoodEntryNotFoundException(id));
    }


    public MoodEntry updateEntry(Long id, MoodEntry updatedMoodEntry) {
        //FIXME: only save tags when not already contained in by
        //FIXME: problem how do entries point to their tags? idk
        tagRepository.saveAll(updatedMoodEntry.getTags());

        return moodEntryRepository.findById(id)
                .map(moodEntry -> {
                    moodEntry.setMood(updatedMoodEntry.getMood());
                    moodEntry.setDescription(updatedMoodEntry.getDescription());
                    moodEntry.setTags(updatedMoodEntry.getTags());
                    return moodEntryRepository.save(moodEntry);
                })
                .orElseThrow(() -> new MoodEntryNotFoundException(id));
    }

    
    public List<MoodEntry> findByMood(BaseMood moodToFind) {
        return moodEntryRepository.findByMood(moodToFind);
    }

    
    public List<MoodEntry> findByTagsIn(List<String> keywords) {
        return moodEntryRepository.findByTagsIn(keywords);
    }

    public List<MoodEntry> fetchEntriesInLastWeek() {
        LocalDate now = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC).toLocalDate();
        LocalDate oneWeekAgo = now.minusWeeks(ONE_WEEK);
        return moodEntryRepository.findMoodEntriesByCreationTimeIsBetween(oneWeekAgo, now);
    }

    public List<MoodEntry> fetchEntriesInLastMonth() {
        LocalDate now = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC).toLocalDate();
        LocalDate oneMonthAgo = now.minusMonths(ONE_MONTH);
        return moodEntryRepository.findMoodEntriesByCreationTimeIsBetween(oneMonthAgo, now);
    }

    public List<MoodEntry> fetchEntriesInLastYear() {
        LocalDate now = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC).toLocalDate();
        LocalDate oneYearAgo = now.minusYears(ONE_YEAR);
        return moodEntryRepository.findMoodEntriesByCreationTimeIsBetween(oneYearAgo, now);
    }

    public List<MoodEntry> fetchEntriesInCustomDate(LocalDate startDate, LocalDate endDate) {
        return moodEntryRepository.findMoodEntriesByCreationTimeIsBetween(startDate, endDate);
    }
}
