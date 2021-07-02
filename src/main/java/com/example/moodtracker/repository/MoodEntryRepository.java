package com.example.moodtracker.repository;

import com.example.moodtracker.model.MoodEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoodEntryRepository extends JpaRepository<MoodEntry, Long> {
}
