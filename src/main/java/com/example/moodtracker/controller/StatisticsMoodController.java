package com.example.moodtracker.controller;

import com.example.moodtracker.model.statistics.Statistics;
import com.example.moodtracker.service.StatisticsMoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class StatisticsMoodController implements StatisticsMoodOperations {
    private final Logger logger = LoggerFactory.getLogger(StatisticsMoodController.class);
    private final StatisticsMoodService service;

    public StatisticsMoodController(StatisticsMoodService service) {
        this.service = service;
    }

    @Override
    public Statistics computeOverview() {
        var overview = service.computeOverview();
        logger.info("Statistics: " + overview.toString());
        return overview;
    }

    @Override
    public Statistics computeOverviewByWeek() {
        return service.computeOverviewByWeek();
    }

    @Override
    public Statistics computeOverviewByMonth() {
        return service.computeOverviewByMonth();
    }

    @Override
    public Statistics computeOverviewByYear() {
        return service.computeOverviewByYear();
    }

    @Override
    public Statistics computeOverviewByCustomDate(LocalDate startDate, LocalDate endDate) {
        return service.computeOverviewByCustomDate(startDate, endDate);
    }
}
