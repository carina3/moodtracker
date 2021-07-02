package com.example.moodtracker.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.*;

@Entity
public class MoodEntry {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private BaseMood mood;
    private String description;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Tag> tags = new HashSet<>();
    private Instant creationTime;

    public MoodEntry() {
        this.creationTime = Instant.now();
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

    public Instant getCreationTime() {
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

    public void setCreationTime(Instant creationTime) {
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
}
