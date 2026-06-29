package com.ak.redrob.model;

public record Experience(
        String company,
        String role,
        int durationMonths,
        String summary
) {
}