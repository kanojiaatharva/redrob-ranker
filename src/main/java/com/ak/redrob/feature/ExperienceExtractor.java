package com.ak.redrob.feature;

import com.ak.redrob.model.Candidate;
import com.ak.redrob.model.JobDescription;

public class ExperienceExtractor implements FeatureExtractor {

    @Override
    public double extract(Candidate candidate,
                          JobDescription jobDescription) {

        return candidate.totalExperienceYears();

    }

}
