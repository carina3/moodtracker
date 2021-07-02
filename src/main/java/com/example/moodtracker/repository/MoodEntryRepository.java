package com.example.moodtracker.repository;

import com.example.moodtracker.model.BaseMood;
import com.example.moodtracker.model.MoodEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoodEntryRepository extends JpaRepository<MoodEntry, Long> {

    public List<MoodEntry> findMoodEntryByMood(BaseMood mood);
}
