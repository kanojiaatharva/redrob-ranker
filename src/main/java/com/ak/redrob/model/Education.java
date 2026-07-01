package com.ak.redrob.model;

import lombok.Builder;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a candidate's educational qualification.
 *
 * @param institution Institution name
 * @param degree Degree obtained
 * @param fieldOfStudy Major or specialization
 * @param startYear Year education started
 * @param endYear Year education completed
 * @param grade Final grade / CGPA / percentage
 * @param tier Institution tier
 */
@Builder
public record Education(

        String institution,

        String degree,

        String fieldOfStudy,

        Integer startYear,

        Integer endYear,

        String grade,

        EducationTier tier

) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

}