package com.ak.redrob.model;

import lombok.Builder;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a language known by the candidate.
 *
 * @param language Language name
 * @param proficiency Language proficiency level
 */
@Builder
public record Language(

        String language,

        LanguageProficiency proficiency

) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

}