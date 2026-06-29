package com.ak.redrob.model;

import java.util.List;

public record JobDescription(
        String title,
        String description,
        List<String> requiredSkills,
        List<String> preferredSkills,
        int minimumExperience
) {
}