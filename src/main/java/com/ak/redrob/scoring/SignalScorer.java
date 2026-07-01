package com.ak.redrob.scoring;

import com.ak.redrob.model.Candidate;
import com.ak.redrob.model.JobDescription;

/**
 * Contract for every scoring signal.
 *
 * Each implementation returns a normalized score
 * between 0.0 and 1.0.
 */
public interface SignalScorer {

    /**
     * Name of scorer.
     */
    String getName();

    /**
     * Calculates normalized score.
     *
     * @param candidate Candidate
     * @param jd Job Description
     * @return score [0,1]
     */
    double score(Candidate candidate,
                 JobDescription jd);

    /**
     * Weight of this scorer.
     */
    double getWeight();

}