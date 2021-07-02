package com.example.moodtracker.configuration;

import com.example.moodtracker.model.BaseMood;
import com.example.moodtracker.model.MoodEntry;
import com.example.moodtracker.model.Tag;
import com.example.moodtracker.repository.MoodEntryRepository;
import com.example.moodtracker.repository.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class LoadDatabase {
    private static final Logger log =
            LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(MoodEntryRepository moodEntryRepository, TagRepository tagRepository) {
        Set<Tag> tags = new HashSet<>();
        tags.add(new Tag("excited"));

        MoodEntry entry = new MoodEntry(BaseMood.HAPPY, "got a raise", tags, Instant.now());

        return args -> {
            log.info("Preloading " + tagRepository.saveAll(tags));
            log.info("Preloading " + moodEntryRepository.save(entry));
        };
    }
}
