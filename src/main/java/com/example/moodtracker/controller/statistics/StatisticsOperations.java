package com.example.moodtracker.controller.statistics;

import com.example.moodtracker.model.statistics.Statistics;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequestMapping(value = "/statistics", consumes = MediaType.APPLICATION_JSON_VALUE)
public interface StatisticsOperations {
    
    @GetMapping("/mood")
    Statistics computeOverviewMood();
    
    @GetMapping("/mood/month")
    Statistics computeOverviewByMonthMood();
    
    @GetMapping("/mood/year")
    Statistics computeOverviewByYearMood();

    @RequestMapping("/mood/week")
    Statistics computeOverviewByWeekMood();

    @GetMapping("/mood/date")
    Statistics computeOverviewByCustomDateMood(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);

}
