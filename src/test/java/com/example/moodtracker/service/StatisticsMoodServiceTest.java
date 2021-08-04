package com.example.moodtracker.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class StatisticsMoodServiceTest {

    @Mock
    private MoodService moodService;

    private StatisticsMoodService statisticsMoodService;

    @BeforeEach
    void initStatisticsMoodService() {
        statisticsMoodService = new StatisticsMoodService(moodService);
    }

    @Test
    void testComputeOverviewMood() {
        when(moodService.fetchAllEntries()).thenReturn(List.of());

        statisticsMoodService.computeOverviewMood();

    }
}