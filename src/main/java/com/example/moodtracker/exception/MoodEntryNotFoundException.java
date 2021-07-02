package com.example.moodtracker.exception;

public class MoodEntryNotFoundException extends RuntimeException{
    public MoodEntryNotFoundException(Long id) {
        super("Could not find mood entry with id = " + id);
    }
}
