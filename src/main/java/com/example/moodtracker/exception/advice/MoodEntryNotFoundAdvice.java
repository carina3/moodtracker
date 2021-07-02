package com.example.moodtracker.exception.advice;

import com.example.moodtracker.exception.MoodEntryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MoodEntryNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(MoodEntryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    String moodEntryNotFoundHandler(MoodEntryNotFoundException e) {
        return e.getMessage();
    }

}
