package com.ak.redrob.parser;

import com.ak.redrob.model.*;

import java.time.Year;
import java.util.Map;

/**
 * Detects suspicious or impossible candidate profiles.
 */
public class HoneypotDetector {

    /**
     * Returns true if the profile appears to be a synthetic /
     * honeypot candidate.
     */
    public boolean isHoneypot(Candidate candidate) {

        if (candidate == null) {
            return true;
        }

        if (invalidCareer(candidate)) {
            return true;
        }

        if (invalidExpertSkills(candidate)) {
            return true;
        }

        if (invalidEducation(candidate)) {
            return true;
        }

        if (perfectAssessmentScores(candidate)) {
            return true;
        }

        if (profileTooEmpty(candidate)) {
            return true;
        }

        return false;
    }

    /**
     * Career duration exceeds total experience.
     */
    private boolean invalidCareer(Candidate candidate) {

        double totalYears =
                candidate.profile().yearsOfExperience();

        int totalMonths =
                (int) (totalYears * 12);

        return candidate.careerHistory()
                .stream()
                .anyMatch(job ->
                        job.durationMonths() > totalMonths);

    }

    /**
     * Too many expert skills with zero duration.
     */
    private boolean invalidExpertSkills(Candidate candidate) {

        long suspicious =
                candidate.skills()
                        .stream()
                        .filter(skill ->
                                skill.proficiency() == SkillProficiency.EXPERT
                                        && skill.durationMonths() == 0)
                        .count();

        return suspicious >= 10;

    }

    /**
     * Impossible education timeline.
     */
    private boolean invalidEducation(Candidate candidate) {

        if (candidate.profile().yearsOfExperience() <= 40) {
            return false;
        }

        int currentYear =
                Year.now().getValue();

        return candidate.education()
                .stream()
                .anyMatch(e ->
                        e.endYear() != null &&
                                e.endYear() > currentYear);

    }

    /**
     * Every assessment score equals 100.
     */
    private boolean perfectAssessmentScores(Candidate candidate) {

        Map<String, Double> scores =
                candidate.redrobSignals()
                        .skillAssessmentScores();

        if (scores == null || scores.isEmpty()) {
            return false;
        }

        return scores.values()
                .stream()
                .allMatch(score -> score == 100.0);

    }

    /**
     * Extremely incomplete profile but huge skill list.
     */
    private boolean profileTooEmpty(Candidate candidate) {

        return candidate.redrobSignals()
                .profileCompletenessScore() < 10
                &&
                candidate.skills().size() >= 20;

    }

}