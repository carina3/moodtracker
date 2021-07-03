package com.example.moodtracker.repository;

import com.example.moodtracker.model.BaseMood;
import com.example.moodtracker.model.MoodEntry;
import com.example.moodtracker.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoodEntryRepository extends JpaRepository<MoodEntry, Long> {

    //mysql> select * from tag as t where t.keyword in ("fressen", "hass");
    public List<MoodEntry> findByMood(BaseMood mood);

    public List<MoodEntry> findByTagsIn(List<Tag> tags);
}
