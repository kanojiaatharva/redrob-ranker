package com.ak.redrob.model;

/**
 * Represents the educational background of a candidate.
 */
public class Education {

    public enum Tier {
        TIER_1,
        TIER_2,
        TIER_3,
        TIER_4,
        UNKNOWN;

        public static Tier fromString(String value) {
            if (value == null) {
                return UNKNOWN;
            }
            switch (value.trim().toLowerCase()) {
                case "tier_1":
                    return TIER_1;
                case "tier_2":
                    return TIER_2;
                case "tier_3":
                    return TIER_3;
                case "tier_4":
                    return TIER_4;
                case "unknown":
                default:
                    return UNKNOWN;
            }
        }
    }

    private final String institution;
    private final String degree;
    private final String fieldOfStudy;
    private final int startYear;
    private final int endYear;
    private final String grade;
    private final Tier tier;

    public Education(String institution, String degree, String fieldOfStudy,
                     int startYear, int endYear, String grade, String tier) {
        this.institution = institution;
        this.degree = degree;
        this.fieldOfStudy = fieldOfStudy;
        this.startYear = startYear;
        this.endYear = endYear;
        this.grade = grade;
        this.tier = Tier.fromString(tier);
    }

    public Education(String institution, String degree, String fieldOfStudy,
                     int startYear, int endYear, String grade, Tier tier) {
        this.institution = institution;
        this.degree = degree;
        this.fieldOfStudy = fieldOfStudy;
        this.startYear = startYear;
        this.endYear = endYear;
        this.grade = grade;
        this.tier = tier != null ? tier : Tier.UNKNOWN;
    }

    public String getInstitution() {
        return institution;
    }

    public String getDegree() {
        return degree;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public String getGrade() {
        return grade;
    }

    public Tier getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return "Education{" +
                "institution='" + institution + '\'' +
                ", degree='" + degree + '\'' +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", tier=" + tier +
                '}';
    }
}
