package com.ak.redrob.model;

/**
 * Represents the normalized institution tier.
 *
 * <p>This can be used by the scoring engine to provide
 * additional weight to institutions if required.</p>
 */
public enum EducationTier {

    /**
     * Top-tier institutions.
     */
    TIER_1,

    /**
     * Upper-mid tier institutions.
     */
    TIER_2,

    /**
     * Mid-tier institutions.
     */
    TIER_3,

    /**
     * Other recognized institutions.
     */
    TIER_4,

    /**
     * Institution tier could not be determined.
     */
    UNKNOWN

}