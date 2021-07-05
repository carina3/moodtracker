package com.example.moodtracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Entry does not exist")
public class MoodEntryNotFoundException extends RuntimeException{
    public MoodEntryNotFoundException(Long id) {
        super("Could not find mood entry with id = " + id);
    }
}
