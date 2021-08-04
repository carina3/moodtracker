package com.example.moodtracker.model.statistics;

import com.example.moodtracker.model.mood.BaseMood;
import com.example.moodtracker.model.mood.MoodEntry;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsMoodTest {


    @Test
    void testComputeOverviewFromEmptyList(){

        var stats = new StatisticsMood();

        stats.setEntries(List.of());
        stats.computeOverviewFrom();

        assertEquals(0d, stats.getAvgMood());

    }

    @Test
    void testComputeOverviewFromSingleHappyMoodEntry() {
        var entry = initMoodEntry(BaseMood.HAPPY);
        var stats = new StatisticsMood();

        stats.setEntries(List.of(entry));
        stats.computeOverviewFrom();

        assertEquals(BaseMood.HAPPY.getValue(), stats.getAvgMood());
    }

    @Test
    void testComputeOverviewFromMultipleHappyMoodEntries() {
        var entry1 = initMoodEntry(BaseMood.HAPPY);
        var entry2 = initMoodEntry(BaseMood.HAPPY);
        var entry3 = initMoodEntry(BaseMood.HAPPY);
        var stats = new StatisticsMood();

        stats.setEntries(List.of(entry1, entry2, entry3));
        stats.computeOverviewFrom();

        assertEquals(BaseMood.HAPPY.getValue(), stats.getAvgMood());
    }

    @Test
    void testComputeOverviewFromMultipleNeutralMoodEntries() {
        var entry1 = initMoodEntry(BaseMood.NEUTRAL);
        var entry2 = initMoodEntry(BaseMood.NEUTRAL);
        var entry3 = initMoodEntry(BaseMood.NEUTRAL);
        var stats = new StatisticsMood();

        stats.setEntries(List.of(entry1, entry2, entry3));
        stats.computeOverviewFrom();

        assertEquals(BaseMood.NEUTRAL.getValue(), stats.getAvgMood());
    }

    @Test
    void testComputeOverviewFromMultipleDifferentMoodEntries() {
        var entry1 = initMoodEntry(BaseMood.HAPPY);
        var entry2 = initMoodEntry(BaseMood.NEUTRAL);
        var entry3 = initMoodEntry(BaseMood.UNHAPPY);
        var stats = new StatisticsMood();

        stats.setEntries(List.of(entry1, entry2, entry3));
        stats.computeOverviewFrom();

        assertEquals(BaseMood.NEUTRAL.getValue(), stats.getAvgMood());
    }

    private MoodEntry initMoodEntry(BaseMood mood) {
        var entry = new MoodEntry();
        entry.setMood(mood);
        return entry;
    }

}