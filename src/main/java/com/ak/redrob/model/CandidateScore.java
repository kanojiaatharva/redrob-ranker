package com.ak.redrob.model;

import com.ak.redrob.scoring.ScoreBreakdown;

public record CandidateScore(
        Candidate candidate,
        double finalScore,
        ScoreBreakdown breakdown
) {
}