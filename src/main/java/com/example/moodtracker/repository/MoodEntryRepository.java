package com.example.moodtracker.repository;

import com.example.moodtracker.model.BaseMood;
import com.example.moodtracker.model.MoodEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;

@RepositoryRestResource
public interface MoodEntryRepository extends JpaRepository<MoodEntry, Long> {

    List<MoodEntry> findByMood(BaseMood mood);

    @Query(value = "SELECT me FROM MoodEntry me INNER JOIN me.tags tags WHERE tags.keyword in :keywords")
    List<MoodEntry> findByTagsIn(List<String> keywords);

    @Query("SELECT me FROM MoodEntry me WHERE me.creationTime BETWEEN :startDate AND :endDate")
    List<MoodEntry> findMoodEntriesByCreationTimeIsBetween(LocalDate startDate, LocalDate endDate);
}
