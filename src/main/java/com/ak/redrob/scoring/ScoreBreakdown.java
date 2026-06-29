package com.ak.redrob.scoring;

import java.util.EnumMap;
import java.util.Map;

/**
 * Breakdown of evaluation scores across different scoring components.
 */
public class ScoreBreakdown {

    private final Map<ScoreComponent, Double> scores;
    private double baseScore;
    private double multiplier;
    private double finalScore;

    public ScoreBreakdown() {
        this.scores = new EnumMap<>(ScoreComponent.class);
        this.baseScore = 0.0;
        this.multiplier = 1.0;
        this.finalScore = 0.0;
    }

    public void setComponentScore(ScoreComponent component, double score) {
        scores.put(component, score);
    }

    public double getComponentScore(ScoreComponent component) {
        return scores.getOrDefault(component, 0.0);
    }

    public Map<ScoreComponent, Double> getScores() {
        return new EnumMap<>(scores);
    }

    public double getBaseScore() {
        return baseScore;
    }

    public void setBaseScore(double baseScore) {
        this.baseScore = baseScore;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(double finalScore) {
        this.finalScore = finalScore;
    }

    @Override
    public String toString() {
        return "ScoreBreakdown{" +
                "scores=" + scores +
                ", baseScore=" + baseScore +
                ", multiplier=" + multiplier +
                ", finalScore=" + finalScore +
                '}';
    }
}
