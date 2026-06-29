package com.ak.redrob.ranking;

/**
 * Represents a candidate placed at a specific rank position with a score and rationale.
 */
public class RankedCandidate implements Comparable<RankedCandidate> {

    private final String candidateId;
    private final int rank;
    private final double score;
    private final String reasoning;

    public RankedCandidate(String candidateId, int rank, double score, String reasoning) {
        this.candidateId = candidateId;
        this.rank = rank;
        this.score = score;
        this.reasoning = reasoning;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public int getRank() {
        return rank;
    }

    public double getScore() {
        return score;
    }

    public String getReasoning() {
        return reasoning;
    }

    @Override
    public int compareTo(RankedCandidate o) {
        return Integer.compare(this.rank, o.rank);
    }

    @Override
    public String toString() {
        return "RankedCandidate{" +
                "candidateId='" + candidateId + '\'' +
                ", rank=" + rank +
                ", score=" + score +
                ", reasoning='" + reasoning + '\'' +
                '}';
    }
}
