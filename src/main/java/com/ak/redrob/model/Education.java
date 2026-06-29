package com.ak.redrob.model;

public record Education(
        String degree,
        String institution,
        String specialization,
        int graduationYear
) {
}