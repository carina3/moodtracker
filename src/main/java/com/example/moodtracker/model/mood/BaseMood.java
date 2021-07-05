package com.example.moodtracker.model.mood;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public enum BaseMood {
    HAPPY(1),
    NEUTRAL(0),
    UNHAPPY(-1);

    private final int value;
    private static Map<Integer, BaseMood> lookup;
    private static final Logger logger = LoggerFactory.getLogger(BaseMood.class);

    private BaseMood(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // Source: https://stackoverflow.com/a/20872663
    static {
        try {
            BaseMood[] values = BaseMood.values();
            lookup = new HashMap<Integer, BaseMood>(values.length);

            for (BaseMood bm : values) {
                lookup.put(bm.getValue(), bm);
            }
        } catch (Exception e) {
            // Careful, if any exception is thrown out of a static block, the class
            // won't be initialized
            logger.error("Unexpected exception initializing " + BaseMood.class, e);
        }
    }

    public static String mapValueToName(int value) {
        BaseMood mood = fromBaseMoodValue(value);
        return mood.name();
    }

    private static BaseMood fromBaseMoodValue(int value) {
        return Optional.ofNullable(lookup.get(value))
                .orElseThrow(
                        () -> new NoSuchElementException("Invalid mood value")
                );
    }
}
