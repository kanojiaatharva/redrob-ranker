package com.ak.redrob.model;

import lombok.Builder;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Top-level immutable domain model representing a candidate.
 *
 * <p>This object aggregates all candidate information required
 * for feature extraction, scoring, and ranking.</p>
 *
 * @param candidateId Unique candidate identifier
 * @param profile Candidate profile information
 * @param careerHistory Complete employment history
 * @param education Educational qualifications
 * @param skills Professional and technical skills
 * @param certifications Professional certifications
 * @param languages Spoken languages
 * @param redrobSignals Behavioral and engagement signals
 */
@Builder
public record Candidate(

        String candidateId,

        CandidateProfile profile,

        List<CareerEntry> careerHistory,

        List<Education> education,

        List<Skill> skills,

        List<Certification> certifications,

        List<Language> languages,

        RedrobSignals redrobSignals

) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

}