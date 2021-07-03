package com.example.moodtracker.repository;

import com.example.moodtracker.model.BaseMood;
import com.example.moodtracker.model.MoodEntry;
import com.example.moodtracker.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoodEntryRepository extends JpaRepository<MoodEntry, Long> {

    public List<MoodEntry> findByMood(BaseMood mood);

    @Query(value = "SELECT me FROM MoodEntry me INNER JOIN me.tags tags WHERE tags.keyword in :keywords")
    public List<MoodEntry> findByTagsIn(List<String> keywords);
}
