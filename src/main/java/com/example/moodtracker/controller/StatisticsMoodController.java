package com.example.moodtracker.controller;

import com.example.moodtracker.model.statistics.Statistics;
import com.example.moodtracker.service.StatisticsMoodService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsMoodController implements StatisticsMoodOperations {
    StatisticsMoodService service;

    public StatisticsMoodController(StatisticsMoodService service) {
        this.service = service;
    }

    @Override
    public Statistics computeOverview() {
        return service.computeOverview();
    }

    @Override
    @RequestMapping("/week")
    public Statistics computeOverviewByWeek() {
        return service.computeOverviewByWeek();
    }

    @Override
    @RequestMapping("/month")
    public Statistics computeOverviewByMonth() {
        return service.computeOverviewByMonth();
    }

    @Override
    @RequestMapping("/year")
    public Statistics computeOverviewByYear() {
        return service.computeOverviewByYear();
    }

    @Override
    @RequestMapping("/custom")
    public Statistics computeOverviewByCustomDate() {
        return null;
    }
}
