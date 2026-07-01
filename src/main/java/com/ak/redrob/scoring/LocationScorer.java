package com.ak.redrob.scoring;

import com.ak.redrob.model.Candidate;
import com.ak.redrob.model.JobDescription;

public class LocationScorer
        implements SignalScorer {

    @Override
    public String getName() {
        return "Location";
    }

    @Override
    public double getWeight() {
        return ScoringWeights.LOCATION;
    }

    @Override
    public double score(
            Candidate candidate,
            JobDescription jd) {

        String location =
                candidate.profile()
                        .location()
                        .toLowerCase();

        if (location.contains("pune")
                ||
                location.contains("bangalore")
                ||
                location.contains("hyderabad")
                ||
                location.contains("mumbai")
                ||
                location.contains("noida")
                ||
                location.contains("delhi"))
            return 1.0;

        if (candidate.redrobSignals()
                .willingToRelocate())
            return 0.70;

        if ("india".equalsIgnoreCase(
                candidate.profile().country()))
            return 0.60;

        return 0.30;

    }

}