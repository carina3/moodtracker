package com.example.moodtracker.model.mood;

import com.example.moodtracker.model.tag.Tag;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

@Entity
public class MoodEntry {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private BaseMood mood;
    private String description;

    @ManyToMany
    private Set<Tag> tags = new HashSet<>();
    private LocalDate creationTime;

    public MoodEntry() {
        creationTime = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC).toLocalDate();
    }

    public MoodEntry(BaseMood mood, String description, Set<Tag> tags) {
        super();
        this.mood = mood;
        this.description = description;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BaseMood getMood() {
        return mood;
    }

    public void setMood(BaseMood mood) {
        this.mood = mood;
    }

    public LocalDate getCreationTime() {
        return creationTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public void setCreationTime(LocalDate creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "MoodEntry{" +
                "id=" + id +
                ", mood=" + mood +
                ", description='" + description + '\'' +
                ", tags=" + tags +
                ", creationTime=" + creationTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodEntry moodEntry = (MoodEntry) o;
        return mood == moodEntry.mood && Objects.equals(description, moodEntry.description) && Objects.equals(tags, moodEntry.tags) && Objects.equals(creationTime, moodEntry.creationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mood, description, tags, creationTime);
    }
}
