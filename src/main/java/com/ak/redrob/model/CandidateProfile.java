package com.ak.redrob.model;

import lombok.Builder;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents the candidate's high-level profile information.
 *
 * <p>This model captures public profile metadata used during
 * feature engineering and ranking.</p>
 *
 * @param anonymizedName     Candidate's anonymized display name
 * @param headline           Professional headline
 * @param summary            Professional summary/about section
 * @param location           Current city/location
 * @param country            Country of residence
 * @param yearsOfExperience  Total years of professional experience
 * @param currentTitle       Current job title
 * @param currentCompany     Current employer
 * @param currentCompanySize Company size category
 * @param currentIndustry    Current industry/domain
 */
@Builder
public record CandidateProfile(

        String anonymizedName,

        String headline,

        String summary,

        String location,

        String country,

        double yearsOfExperience,

        String currentTitle,

        String currentCompany,

        String currentCompanySize,

        String currentIndustry

) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

}