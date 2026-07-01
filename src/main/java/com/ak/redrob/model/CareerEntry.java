package com.ak.redrob.model;

import lombok.Builder;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Represents a single employment record in a candidate's career history.
 *
 * <p>Multiple career entries together form the complete
 * professional timeline.</p>
 *
 * @param company         Employer name
 * @param title           Job title/designation
 * @param startDate       Employment start date
 * @param endDate         Employment end date (null if current)
 * @param durationMonths  Total duration in months
 * @param isCurrent       Whether this is the current position
 * @param industry        Industry of the employer
 * @param companySize     Employer size/category
 * @param description     Responsibilities and achievements
 */
@Builder
public record CareerEntry(

        String company,

        String title,

        LocalDate startDate,

        LocalDate endDate,

        int durationMonths,

        boolean isCurrent,

        String industry,

        String companySize,

        String description

) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

}