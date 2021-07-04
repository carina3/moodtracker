package com.example.moodtracker.service;

import com.example.moodtracker.model.statistics.Statistics;
import com.example.moodtracker.model.statistics.StatisticsMood;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

    //TODO: was wenn entries leer? error handling machen
    public Statistics computeOverviewByWeek() {
        //TODO: query entries by time
        var entries = moodService.fetchEntriesInLastWeek();
        if (entries.size() > 0) {
            statisticsMood.setMoodEntries(entries);
            statisticsMood.computeOverview();
        }
        return statisticsMood;
    }

    //TODO: redundancy and error handlingn
    public Statistics computeOverviewByMonth() {
        var entries = moodService.fetchEntriesInLastMonth();
        if (entries.size() > 0) {
            statisticsMood.setMoodEntries(entries);
            statisticsMood.computeOverview();
        }
        return statisticsMood;
    }

    //TODO: redundancy and error handlingn
    public Statistics computeOverviewByYear() {
        var entries = moodService.fetchEntriesInLastYear();
        if (entries.size() > 0) {
            statisticsMood.setMoodEntries(entries);
            statisticsMood.computeOverview();
        }
        return statisticsMood;
    }

    public Statistics computeOverviewByCustomDate(LocalDate startDate, LocalDate endDate) {
        var entries = moodService.fetchEntriesInCustomDate(startDate, endDate);
        if (entries.size() > 0) {
            statisticsMood.setMoodEntries(entries);
            statisticsMood.computeOverview();
        }
        return statisticsMood;
    }


}
