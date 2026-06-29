package com.ak.redrob.scoring;

/**
 * Enumerates the distinct evaluation components used to calculate candidate relevance.
 */
public enum ScoreComponent {
    /**
     * Match between candidate's declared skills (and assessment results/endorsements) and JD requirements.
     */
    SKILL_ALIGNMENT,

    /**
     * Assessment of candidate's total years of experience compared to target bounds.
     */
    EXPERIENCE_ALIGNMENT,

    /**
     * Evaluation of candidate's history (e.g. tenure, target product company vs services/consulting, and title progressions).
     */
    CAREER_TRAJECTORY,

    /**
     * Location match/relocation willingness.
     */
    LOCATION_ALIGNMENT,

    /**
     * Notice period preference mapping.
     */
    NOTICE_PERIOD_ALIGNMENT,

    /**
     * Behavioral signals modifier (last active date, recruiter response rate, applications submitted).
     */
    BEHAVIORAL_ENGAGEMENT
}
