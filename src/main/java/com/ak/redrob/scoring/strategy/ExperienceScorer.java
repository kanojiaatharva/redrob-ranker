package com.ak.redrob.scoring.strategy;

import com.ak.redrob.model.Candidate;
import com.ak.redrob.model.JobDescription;

public class ExperienceScorer {

    public double score(Candidate candidate,
                        JobDescription job) {

        if (job.minimumExperience() <= 0)
            return 1.0;

        return Math.min(
                candidate.totalExperienceYears()
                        / job.minimumExperience(),
                1.0
        );

    }

}
