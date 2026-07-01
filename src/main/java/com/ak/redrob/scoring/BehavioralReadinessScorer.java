package com.ak.redrob.scoring;

import com.ak.redrob.model.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BehavioralReadinessScorer {

    public double modifier(
            Candidate candidate) {

        RedrobSignals s =
                candidate.redrobSignals();

        double score = 1.0;

        if (s.openToWorkFlag())
            score += 0.15;

        long days =
                ChronoUnit.DAYS.between(
                        s.lastActiveDate(),
                        LocalDate.now());

        if (days <= 7)
            score += 0.15;

        else if (days <= 30)
            score += 0.08;

        else if (days > 180)
            score -= 0.40;

        else if (days > 90)
            score -= 0.20;

        if (s.recruiterResponseRate() >= 0.7)
            score += 0.10;

        else if (s.recruiterResponseRate() >= 0.4)
            score += 0.05;

        else if (s.recruiterResponseRate() < 0.1)
            score -= 0.15;

        if (s.avgResponseTimeHours() < 4)
            score += 0.05;

        else if (s.avgResponseTimeHours() > 48)
            score -= 0.05;

        if (s.noticePeriodDays() <= 30)
            score += 0.10;

        else if (s.noticePeriodDays() > 90)
            score -= 0.15;

        else if (s.noticePeriodDays() > 60)
            score -= 0.05;

        if (s.interviewCompletionRate() >= 0.8)
            score += 0.05;

        else if (s.interviewCompletionRate() < 0.3)
            score -= 0.10;

        if (s.offerAcceptanceRate() >= 0.7)
            score += 0.05;

        if (s.githubActivityScore() >= 60)
            score += 0.10;

        else if (s.githubActivityScore() >= 30)
            score += 0.05;

        if (s.profileCompletenessScore() >= 90)
            score += 0.05;

        if (s.savedByRecruiters30d() >= 5)
            score += 0.05;

        return Math.max(
                0.10,
                Math.min(score, 1.50));

    }

}