package com.example.moodtracker.controller;

import com.example.moodtracker.model.BaseMood;
import com.example.moodtracker.model.statistics.Statistics;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/statistics/mood", consumes = MediaType.APPLICATION_JSON_VALUE)
public interface StatisticsMoodOperations {

    //GET moodEntry
    @GetMapping
    Statistics computeOverview();


    //GET search/tag/find
    @GetMapping
    Statistics computeOverviewByMonth();
    
    @GetMapping
    Statistics computeOverviewByYear();

    @RequestMapping
    Statistics computeOverviewByWeek();

    @GetMapping
    Statistics computeOverviewByCustomDate();


}
