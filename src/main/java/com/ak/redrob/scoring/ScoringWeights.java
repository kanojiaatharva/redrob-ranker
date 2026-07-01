package com.ak.redrob.scoring;

/**
 * Central location for all scoring weights.
 *
 * Sum of weighted scorers = 0.80
 *
 * BehavioralReadinessScorer
 * acts as a multiplier.
 */
public final class ScoringWeights {

    private ScoringWeights() {}

    public static final double SKILL = 0.35;

    public static final double TITLE = 0.25;

    public static final double EXPERIENCE = 0.15;

    public static final double LOCATION = 0.05;

}