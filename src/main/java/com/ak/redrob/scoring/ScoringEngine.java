package com.ak.redrob.scoring;

import com.ak.redrob.model.Candidate;
import com.ak.redrob.model.JobDescription;
import com.ak.redrob.model.CandidateScore;
import com.ak.redrob.exception.RankingException;

/**
 * Interface contract for scoring candidate profiles against job descriptions.
 */
public interface ScoringEngine {

    /**
     * Calculates the relevance score and breakdown for a candidate against a job description.
     *
     * @param candidate      the candidate profile
     * @param jobDescription the target job description criteria
     * @return the computed score and detailed breakdown
     * @throws RankingException if scoring operations fail
     */
    CandidateScore score(Candidate candidate, JobDescription jobDescription) throws RankingException;
}
