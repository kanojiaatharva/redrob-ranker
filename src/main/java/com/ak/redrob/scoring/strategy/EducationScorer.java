package com.ak.redrob.scoring.strategy;

import com.ak.redrob.model.Candidate;
import com.ak.redrob.model.JobDescription;

public class EducationScorer {

    public double score(Candidate candidate,
                        JobDescription job) {

        if (candidate.education() == null)
            return 0;

        return candidate.education().isEmpty()
                ? 0
                : 1;

    }

}
