package com.ak.redrob.scoring.strategy;

import com.ak.redrob.model.Candidate;
import com.ak.redrob.model.JobDescription;

public class KeywordScorer {

    public double score(Candidate candidate,
                        JobDescription job) {

        String resume =
                candidate.resumeText().toLowerCase();

        String jd =
                job.description().toLowerCase();

        int matches = 0;

        for (String word : jd.split("\\s+")) {

            if (resume.contains(word))
                matches++;

        }

        return (double) matches / jd.split("\\s+").length;

    }

}
