package com.example.moodtracker.advice;

import com.example.moodtracker.editor.StringLowerCaseEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class MoodControllerAdvice {

    public void initBinder( WebDataBinder dataBinder ) {
        StringLowerCaseEditor lowerCaseEditor = new StringLowerCaseEditor();
        dataBinder.registerCustomEditor( String.class, lowerCaseEditor );
    }
}
