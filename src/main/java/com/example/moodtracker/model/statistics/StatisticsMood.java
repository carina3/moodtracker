package com.example.moodtracker.model.statistics;

import com.example.moodtracker.model.BaseMood;
import com.example.moodtracker.model.MoodEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class StatisticsMood implements Statistics {
    private final Logger logger = LoggerFactory.getLogger(StatisticsMood.class);

    private List<MoodEntry> moodEntries;
    private String avgMood;
    private String bestMood;
    private String worstMood;

    public StatisticsMood() {
    }

    public StatisticsMood(List<MoodEntry> moodEntries) {
        this.moodEntries = moodEntries;

    }

    public void computeOverview() {
        avgMood = computeAvgMood();
        bestMood = computeBestMood();
        worstMood = computeWorstMood();
    }

    private String computeWorstMood() {
        int worst = moodEntries
                .stream()
                .map(MoodEntry::getMood)
                .map(BaseMood::getValue)
                .mapToInt(v -> v)
                .min().orElseThrow(NoSuchElementException::new);

        String worstMood = BaseMood.mapValueToName(worst);
        return worstMood;
    }

    private String computeBestMood() {
        int best = moodEntries
                .stream()
                .map(MoodEntry::getMood)
                .map(BaseMood::getValue)
                .mapToInt(v -> v)
                .max().orElseThrow(NoSuchElementException::new);

        String bestMood = BaseMood.mapValueToName(best);
        return bestMood;
    }

    private String computeAvgMood() {
        double avg = moodEntries
                .stream()
                .map(MoodEntry::getMood)
                .map(BaseMood::getValue)
                .mapToInt(v -> v)
                .average().orElseThrow(NoSuchElementException::new);

        // TODO: map double to some mood
        //  String worstMood = BaseMood.mapValueToName(avg);
        return ""+avg;
    }

    public List<MoodEntry> getMoodEntries() {
        return moodEntries;
    }

    public void setMoodEntries(List<MoodEntry> moodEntries) {
        this.moodEntries = moodEntries;
    }

    public String getAvgMood() {
        return avgMood;
    }

    public String getBestMood() {
        return bestMood;
    }

    public String getWorstMood() {
        return worstMood;
    }


    @Override
    public String toString() {
        return "StatisticsMood{" +
                "avgMood='" + avgMood + '\'' +
                ", bestMood='" + bestMood + '\'' +
                ", worstMood='" + worstMood + '\'' +
                '}';
    }
}
