package com.ak.redrob.model;

/**
 * Represents a skill possessed by a candidate.
 */
public class Skill {

    public enum Proficiency {
        BEGINNER,
        INTERMEDIATE,
        ADVANCED,
        EXPERT;

        public static Proficiency fromString(String value) {
            if (value == null) {
                return BEGINNER;
            }
            switch (value.trim().toLowerCase()) {
                case "expert":
                    return EXPERT;
                case "advanced":
                    return ADVANCED;
                case "intermediate":
                    return INTERMEDIATE;
                case "beginner":
                default:
                    return BEGINNER;
            }
        }
    }

    private final String name;
    private final Proficiency proficiency;
    private final int endorsements;
    private final int durationMonths;

    public Skill(String name, String proficiency, int endorsements, int durationMonths) {
        this.name = name;
        this.proficiency = Proficiency.fromString(proficiency);
        this.endorsements = endorsements;
        this.durationMonths = durationMonths;
    }

    public Skill(String name, Proficiency proficiency, int endorsements, int durationMonths) {
        this.name = name;
        this.proficiency = proficiency != null ? proficiency : Proficiency.BEGINNER;
        this.endorsements = endorsements;
        this.durationMonths = durationMonths;
    }

    public String getName() {
        return name;
    }

    public Proficiency getProficiency() {
        return proficiency;
    }

    public int getEndorsements() {
        return endorsements;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                ", proficiency=" + proficiency +
                ", endorsements=" + endorsements +
                ", durationMonths=" + durationMonths +
                '}';
    }
}
