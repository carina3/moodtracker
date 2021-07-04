package com.example.moodtracker.controller;

import com.example.moodtracker.model.BaseMood;
import com.example.moodtracker.model.statistics.Statistics;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequestMapping(value = "/statistics/mood", consumes = MediaType.APPLICATION_JSON_VALUE)
public interface StatisticsMoodOperations {

    //GET moodEntry
    @GetMapping
    Statistics computeOverview();


    //GET search/tag/find
    @GetMapping("/month")
    Statistics computeOverviewByMonth();
    
    @GetMapping("/year")
    Statistics computeOverviewByYear();

    @RequestMapping("/week")
    Statistics computeOverviewByWeek();

    @GetMapping("/custom")
    Statistics computeOverviewByCustomDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);
}
