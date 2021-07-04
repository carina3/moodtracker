package com.example.moodtracker.service;

import com.example.moodtracker.model.statistics.Statistics;
import com.example.moodtracker.model.statistics.StatisticsMood;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StatisticsMoodService {
    private final Logger logger = LoggerFactory.getLogger(StatisticsMoodService.class);

    private final MoodService moodService;
    StatisticsMood statisticsMood;

    public StatisticsMoodService(MoodService moodService) {
        this.moodService = moodService;
        statisticsMood = new StatisticsMood();
    }

    public Statistics computeOverview() {
        statisticsMood.setMoodEntries(moodService.fetchAllEntries());
        statisticsMood.computeOverview();
        return statisticsMood;
    }

    
    public Statistics computeOverviewByWeek() {
        //TODO: query entries by time
        var entries = moodService.fetchEntriesInLastWeek();
        statisticsMood.setMoodEntries(entries);
        statisticsMood.computeOverview();
        return statisticsMood;
    }

    
    public Statistics computeOverviewByMonth() {
        return null;
    }

    
    public Statistics computeOverviewByYear() {
        return null;
    }

    
    public Statistics computeOverviewByCustomDate() {
        return null;
    }
}
