package com.ak.redrob.ranking;

import com.ak.redrob.model.CandidateScore;

public record RankedCandidate(
        int rank,
        CandidateScore score
) {
}