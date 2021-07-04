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
import java.util.HashSet;
import java.util.Set;

@Configuration
public class LoadDatabase {
    private static final Logger log =
            LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(MoodEntryRepository moodEntryRepository, TagRepository tagRepository) {
        Set<Tag> tags1 = new HashSet<>();
        tags1.add(new Tag("tired"));

        Set<Tag> tags2 = new HashSet<>();
        tags2.add(new Tag("excited"));
        tags2.add(new Tag("motivated"));

        Set<Tag> tags3 = new HashSet<>();
        tags1.add(new Tag("bored"));

        MoodEntry entry1 = new MoodEntry(BaseMood.UNHAPPY, "couldn't sleep", tags1);
        MoodEntry entry2 = new MoodEntry(BaseMood.HAPPY, "got a raise", tags2);
        MoodEntry entry3 = new MoodEntry(BaseMood.NEUTRAL, "don't know what to do", tags3);

        return args -> {
            log.info("Preloading " + tagRepository.saveAll(tags1));
            log.info("Preloading " + tagRepository.saveAll(tags2));
            log.info("Preloading " + tagRepository.saveAll(tags3));

            log.info("Preloading " + moodEntryRepository.save(entry1));
            log.info("Preloading " + moodEntryRepository.save(entry2));
            log.info("Preloading " + moodEntryRepository.save(entry3));
        };
    }
}
