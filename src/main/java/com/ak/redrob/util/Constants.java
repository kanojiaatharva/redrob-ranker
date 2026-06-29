package com.ak.redrob.util;

/**
 * Common constants utilized across the candidate ranking modules.
 */
public final class Constants {

    private Constants() {
        // Prevent instantiation
    }

    public static final String CANDIDATE_ID_HEADER = "candidate_id";
    public static final String RANK_HEADER = "rank";
    public static final String SCORE_HEADER = "score";
    public static final String REASONING_HEADER = "reasoning";

    public static final int TOP_K_LIMIT = 100;

    /**
     * Regular expression enforcing the required Candidate ID pattern (e.g. CAND_1234567).
     */
    public static final String CANDIDATE_ID_PATTERN = "^CAND_[0-9]{7}$";
}
