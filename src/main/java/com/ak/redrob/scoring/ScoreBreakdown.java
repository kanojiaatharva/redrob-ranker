package com.ak.redrob.scoring;

import java.util.EnumMap;
import java.util.Map;

public class ScoreBreakdown {

    private final Map<ScoreComponent, Double> scores =
            new EnumMap<>(ScoreComponent.class);

    public void add(ScoreComponent component, double value) {
        scores.put(component, value);
    }

    public double get(ScoreComponent component) {
        return scores.getOrDefault(component, 0.0);
    }

    public Map<ScoreComponent, Double> asMap() {
        return Map.copyOf(scores);
    }

    public double total() {
        return scores.values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}