package com.ak.redrob.model;

import lombok.Builder;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

/**
 * Represents behavioral and platform engagement signals
 * available for candidate ranking.
 */
@Builder
public record RedrobSignals(

        /**
         * Overall profile completeness score.
         */
        double profileCompletenessScore,

        /**
         * Candidate signup date.
         */
        LocalDate signupDate,

        /**
         * Last platform activity.
         */
        LocalDate lastActiveDate,

        /**
         * Candidate marked Open To Work.
         */
        boolean openToWorkFlag,

        /**
         * Profile views in last 30 days.
         */
        int profileViewsReceived30d,

        /**
         * Applications submitted in last 30 days.
         */
        int applicationsSubmitted30d,

        /**
         * Recruiter response rate.
         */
        double recruiterResponseRate,

        /**
         * Average recruiter response time.
         */
        double avgResponseTimeHours,

        /**
         * Skill assessment scores.
         */
        Map<String, Double> skillAssessmentScores,

        /**
         * Number of platform connections.
         */
        int connectionCount,

        /**
         * Total endorsements received.
         */
        int endorsementsReceived,

        /**
         * Notice period.
         */
        int noticePeriodDays,

        /**
         * Expected minimum salary (LPA).
         */
        double expectedSalaryMinLpa,

        /**
         * Expected maximum salary (LPA).
         */
        double expectedSalaryMaxLpa,

        /**
         * Preferred work mode.
         */
        String preferredWorkMode,

        /**
         * Willing to relocate.
         */
        boolean willingToRelocate,

        /**
         * GitHub activity score.
         */
        double githubActivityScore,

        /**
         * Search appearances during last month.
         */
        int searchAppearance30d,

        /**
         * Saved by recruiters.
         */
        int savedByRecruiters30d,

        /**
         * Interview completion rate.
         */
        double interviewCompletionRate,

        /**
         * Offer acceptance rate.
         */
        double offerAcceptanceRate,

        /**
         * Email verified.
         */
        boolean verifiedEmail,

        /**
         * Phone verified.
         */
        boolean verifiedPhone,

        /**
         * LinkedIn connected.
         */
        boolean linkedinConnected

) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

}