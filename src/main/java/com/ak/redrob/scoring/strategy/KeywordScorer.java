package com.ak.redrob.scoring.strategy;

import com.ak.redrob.model.Candidate;
import com.ak.redrob.model.JobDescription;

public class KeywordScorer {

    public double score(Candidate candidate,
                        JobDescription job) {

        String resume = String.join(" ",
                candidate.profile().headline(),
                candidate.profile().summary()
        ).toLowerCase();

        String jd = String.join(" ",
                job.requiredSkills()
        ).toLowerCase();

        int matches = 0;

        for (String word : jd.split("\\s+")) {

            if (resume.contains(word))
                matches++;

        }

        return (double) matches / jd.split("\\s+").length;

    }

}
