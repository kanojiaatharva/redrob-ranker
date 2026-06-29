package com.ak.redrob.model;

import com.ak.redrob.scoring.ScoreBreakdown;

/**
 * Holds the scoring details and rationale computed for a candidate.
 */
public class CandidateScore {

    private final String candidateId;
    private final double totalScore;
    private final ScoreBreakdown breakdown;
    private final String reasoning;

    public CandidateScore(String candidateId, double totalScore, ScoreBreakdown breakdown, String reasoning) {
        this.candidateId = candidateId;
        this.totalScore = totalScore;
        this.breakdown = breakdown;
        this.reasoning = reasoning;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public ScoreBreakdown getBreakdown() {
        return breakdown;
    }

    public String getReasoning() {
        return reasoning;
    }

    @Override
    public String toString() {
        return "CandidateScore{" +
                "candidateId='" + candidateId + '\'' +
                ", totalScore=" + totalScore +
                ", reasoning='" + reasoning + '\'' +
                '}';
    }
}
