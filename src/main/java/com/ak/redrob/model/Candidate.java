package com.ak.redrob.model;

import java.util.List;

public record Candidate(
        String id,
        String name,
        String email,
        List<Skill> skills,
        List<Experience> experiences,
        List<Education> education,
        double totalExperienceYears,
        String resumeText
) {
}