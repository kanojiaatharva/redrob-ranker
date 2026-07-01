package com.ak.redrob.scoring.strategy;

import com.ak.redrob.model.Candidate;
import com.ak.redrob.model.JobDescription;

public class ExperienceScorer {

    public double score(Candidate candidate,
                        JobDescription job) {

        if (job.requiredYearsMin() <= 0)
            return 1.0;

        return Math.min(
                candidate.profile().yearsOfExperience()
                        / job.requiredYearsMin(),
                1.0
        );

    }

}
