package com.ak.redrob.scoring.strategy;

import com.ak.redrob.model.Candidate;
import com.ak.redrob.model.JobDescription;

public class SkillScorer {

    public double score(Candidate candidate,
                        JobDescription job) {

        if (candidate.skills() == null || job.requiredSkills() == null)
            return 0;

        long matches = candidate.skills()
                .stream()
                .map(skill -> skill.name().toLowerCase())
                .filter(job.requiredSkills()
                        .stream()
                        .map(String::toLowerCase)
                        .toList()::contains)
                .count();

        return (double) matches / job.requiredSkills().size();

    }

}
