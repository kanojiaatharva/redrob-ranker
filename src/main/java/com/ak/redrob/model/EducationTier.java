package com.ak.redrob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Locale;

public enum EducationTier {

    TIER_1,
    TIER_2,
    TIER_3,
    TIER_4,
    UNKNOWN;

    @JsonCreator
    public static EducationTier fromValue(String value) {

        if (value == null) {
            return UNKNOWN;
        }

        return switch (value.trim().toUpperCase(Locale.ROOT)) {

            case "TIER_1" -> TIER_1;

            case "TIER_2" -> TIER_2;

            case "TIER_3" -> TIER_3;

            case "TIER_4" -> TIER_4;

            default -> UNKNOWN;

        };

    }

    @JsonValue
    public String toValue() {

        return name().toLowerCase(Locale.ROOT);

    }

}