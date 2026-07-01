package com.ak.redrob.scoring;

import com.ak.redrob.model.*;

import java.util.List;
import java.util.Locale;

public class ExperienceScorer
        implements SignalScorer {

    @Override
    public String getName() {
        return "Experience";
    }

    @Override
    public double getWeight() {
        return ScoringWeights.EXPERIENCE;
    }

    @Override
    public double score(Candidate candidate,
                        JobDescription jd) {

        double years =
                candidate.profile()
                        .yearsOfExperience();

        double score;

        if (years < 3)
            score = 0.30;

        else if (years < 5)
            score = 0.60;

        else if (years <= 9)
            score = 1.0;

        else if (years <= 12)
            score = 0.85;

        else
            score = 0.70;

        score += educationBonus(candidate);

        score += certificationBonus(candidate);

        return Math.min(score, 1.0);

    }

    private double educationBonus(
            Candidate candidate) {

        double bonus = 0;

        for (Education education :
                candidate.education()) {

            if (education.tier() ==
                    EducationTier.TIER_1)
                bonus += 0.10;

            else if (education.tier() ==
                    EducationTier.TIER_2)
                bonus += 0.05;

            String field =
                    education.fieldOfStudy()
                            .toLowerCase(Locale.ROOT);

            if (field.contains("computer")
                    ||
                    field.contains("statistics")
                    ||
                    field.contains("math")
                    ||
                    field.contains("electrical"))
                bonus += 0.05;

        }

        return Math.min(bonus, 0.20);

    }

    private double certificationBonus(
            Candidate candidate) {

        double bonus = 0;

        for (Certification cert :
                candidate.certifications()) {

            String name =
                    cert.name()
                            .toLowerCase(Locale.ROOT);

            if (name.contains("aws")
                    ||
                    name.contains("azure")
                    ||
                    name.contains("gcp")
                    ||
                    name.contains("machine learning")
                    ||
                    name.contains("ai")) {

                bonus += 0.05;

            }

        }

        return Math.min(bonus, 0.15);

    }

}