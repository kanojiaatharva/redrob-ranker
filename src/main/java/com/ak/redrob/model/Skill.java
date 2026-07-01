package com.ak.redrob.model;

import lombok.Builder;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a professional or technical skill possessed by a candidate.
 *
 * @param name Skill name
 * @param proficiency Self-declared or inferred proficiency level
 * @param endorsements Number of endorsements received
 * @param durationMonths Experience using the skill (months)
 */
@Builder
public record Skill(

        String name,

        SkillProficiency proficiency,

        int endorsements,

        int durationMonths

) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

}