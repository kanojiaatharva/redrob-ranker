package com.ak.redrob.model;

import lombok.Builder;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Parsed representation of a Job Description.
 *
 * <p>This object is produced by the Job Description parser and consumed
 * by the scoring engine to evaluate candidates.</p>
 *
 * @param requiredSkills Mandatory technical skills.
 * @param preferredSkills Nice-to-have technical skills.
 * @param requiredYearsMin Minimum required years of experience.
 * @param requiredYearsMax Maximum preferred years of experience.
 * @param targetTitles Target job titles.
 * @param targetIndustries Preferred industries.
 * @param locationKeywords Location preferences.
 * @param redFlags Resume red flags.
 * @param noticePeriodMaxDays Maximum acceptable notice period.
 * @param salaryBudgetMaxLpa Maximum salary budget.
 */
@Builder
public record JobDescription(

        List<String> requiredSkills,

        List<String> preferredSkills,

        int requiredYearsMin,

        int requiredYearsMax,

        List<String> targetTitles,

        List<String> targetIndustries,

        List<String> locationKeywords,

        List<String> redFlags,

        int noticePeriodMaxDays,

        double salaryBudgetMaxLpa

) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

}