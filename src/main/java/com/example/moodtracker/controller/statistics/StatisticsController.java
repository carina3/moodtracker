package com.example.moodtracker.controller.statistics;

import com.example.moodtracker.model.statistics.Statistics;
import com.example.moodtracker.service.StatisticsMoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class StatisticsController implements StatisticsOperations {
    private final Logger logger = LoggerFactory.getLogger(StatisticsController.class);
    private final StatisticsMoodService moodService;

    public StatisticsController(StatisticsMoodService moodService) {
        this.moodService = moodService;
    }

    @Override
    public Statistics computeOverviewMood() {
        var overview = moodService.computeOverviewMood();
        logger.info("Statistics: " + overview.toString());
        return overview;
    }

    @Override
    public Statistics computeOverviewByWeekMood() {
        return moodService.computeOverviewByWeekMood();
    }

    @Override
    public Statistics computeOverviewByMonthMood() {
        return moodService.computeOverviewByMonthMood();
    }

    @Override
    public Statistics computeOverviewByYearMood() {
        return moodService.computeOverviewByYearMood();
    }

    @Override
    public Statistics computeOverviewByCustomDateMood(LocalDate startDate, LocalDate endDate) {
        return moodService.computeOverviewByCustomDateMood(startDate, endDate);
    }

}
