package com.ak.redrob.model;

import lombok.Builder;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a professional certification earned by the candidate.
 *
 * @param name Certification name
 * @param issuer Issuing organization
 * @param year Year of completion
 */
@Builder
public record Certification(

        String name,

        String issuer,

        Integer year

) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

}