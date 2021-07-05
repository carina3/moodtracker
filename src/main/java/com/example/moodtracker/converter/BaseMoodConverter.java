package com.example.moodtracker.converter;

import com.example.moodtracker.model.mood.BaseMood;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;



@Component
public class BaseMoodConverter implements Converter<String, BaseMood> {
    @Override
    public BaseMood convert(String mood) {
        return BaseMood.valueOf(mood.toUpperCase());
    }
}
