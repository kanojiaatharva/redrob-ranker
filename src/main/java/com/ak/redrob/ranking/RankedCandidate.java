package com.ak.redrob.ranking;

import lombok.Builder;

/**
 * Final ranked candidate written to submission CSV.
 *
 * @param candidateId Candidate identifier
 * @param rank Final rank (1-100)
 * @param score Final score
 * @param reasoning Human-readable explanation
 */
@Builder
public record RankedCandidate(

        String candidateId,

        int rank,

        double score,

        String reasoning

) {
}