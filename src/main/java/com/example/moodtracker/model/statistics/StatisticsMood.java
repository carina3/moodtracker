package com.example.moodtracker.model.statistics;

import com.example.moodtracker.model.mood.BaseMood;
import com.example.moodtracker.model.mood.MoodEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatisticsMood implements Statistics {
    private final Logger logger = LoggerFactory.getLogger(StatisticsMood.class);

    private List<MoodEntry> moodEntries;
    private double avgMood;
    private int bestMood;
    private int worstMood;
    private long count;
    private long sum;

    public StatisticsMood() {
    }

    public StatisticsMood(List<MoodEntry> moodEntries) {
        this.moodEntries = moodEntries;

    }

    @Override
    public void computeOverviewFrom() {
        var statistics = moodEntries
                .stream()
                .map(MoodEntry::getMood)
                .map(BaseMood::getValue)
                .mapToInt(d -> d)
                .summaryStatistics();
        avgMood =  statistics.getAverage();
        bestMood = statistics.getMax();
        worstMood = statistics.getMin();
        count = statistics.getCount();
        sum = statistics.getSum();
    }

    public List<MoodEntry> getEntries() {
        return moodEntries;
    }

    public void setEntries(List<MoodEntry> moodEntries) {
        this.moodEntries = moodEntries;
    }

    public double getAvgMood() {
        return avgMood;
    }

    public int getBestMood() {
        return bestMood;
    }

    public int getWorstMood() {
        return worstMood;
    }

    public long getCount() {
        return count;
    }

    public long getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "StatisticsMood{" +
                "avgMood=" + avgMood +
                ", bestMood=" + bestMood +
                ", worstMood=" + worstMood +
                ", count=" + count +
                ", sum=" + sum +
                '}';
    }
}
