package com.example.moodtracker.model;

public enum BaseMood {

    HAPPY(1),
    NEUTRAL(0),
    UNHAPPY(-1);

    private final int value;

    private BaseMood(int value) {
        this.value = value;
    }

}
