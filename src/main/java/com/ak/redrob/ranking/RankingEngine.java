package com.ak.redrob.ranking;

import com.ak.redrob.model.Candidate;
import com.ak.redrob.model.JobDescription;
import com.ak.redrob.exception.RankingException;

import java.util.List;
import java.util.stream.Stream;

/**
 * Interface contract for evaluating and ranking a pool of candidate profiles
 * against a job description, returning a sorted list of top-K results.
 */
public interface RankingEngine {

    /**
     * Scores and ranks candidates, returning the top-K matches sorted descending by score.
     *
     * @param candidates     a Stream of candidates to evaluate
     * @param jobDescription the target job requirements
     * @param limit          the maximum number of results to return (top-K)
     * @return the sorted list of RankedCandidate DTOs
     * @throws RankingException if ranking operations fail
     */
    List<RankedCandidate> rank(Stream<Candidate> candidates, JobDescription jobDescription, int limit) throws RankingException;
}
