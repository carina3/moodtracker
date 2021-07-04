package com.example.moodtracker.model.statistics;

import com.example.moodtracker.model.MoodEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MoodOverview {
    private final Logger logger = LoggerFactory.getLogger(MoodOverview.class);

    private String avgMood;
    private String bestMood;
    private String worstMood;

    public MoodOverview() {
    }

    public MoodOverview(List<MoodEntry> moodEntries) {
        avgMood = computeAverageMood(moodEntries);
        bestMood = computeBestMood(moodEntries);
        worstMood = computeWorstMood(moodEntries);
    }

    private String computeAverageMood(List<MoodEntry> moodEntries) {
        return null;
    }

    private String computeWorstMood(List<MoodEntry> moodEntries) {
        return null;
    }

    private String computeBestMood(List<MoodEntry> moodEntries) {
        return null;
    }

    public String getAvgMood() {
        return avgMood;
    }

    public void setAvgMood(String avgMood) {
        this.avgMood = avgMood;
    }

    public String getBestMood() {
        return bestMood;
    }

    public void setBestMood(String bestMood) {
        this.bestMood = bestMood;
    }

    public String getWorstMood() {
        return worstMood;
    }

    public void setWorstMood(String worstMood) {
        this.worstMood = worstMood;
    }



    @Override
    public String toString() {
        return "MoodOverview{" +
                "avgMood='" + avgMood + '\'' +
                ", bestMood='" + bestMood + '\'' +
                ", worstMood='" + worstMood + '\'' +
                '}';
    }
}
