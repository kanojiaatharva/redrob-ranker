package com.ak.redrob.model;

import java.util.List;
import java.util.Set;

/**
 * Represents a parsed Job Description containing keywords, target domains,
 * criteria limits, and explicit filter/disqualification rules.
 */
public class JobDescription {

    private final String title;
    private final String company;
    private final double minYearsExperience;
    private final double maxYearsExperience;
    private final Set<String> targetLocations;
    private final Set<String> requiredSkills;
    private final Set<String> preferredSkills;
    private final Set<String> disqualifiedKeywords; // consulting companies or title-chasing cues
    private final Set<String> disqualifiedCompanies; // consulting companies e.g., TCS, Infosys, Wipro, etc.
    private final int preferredNoticePeriodDays;

    public JobDescription(String title, String company, double minYearsExperience, double maxYearsExperience,
                          Set<String> targetLocations, Set<String> requiredSkills, Set<String> preferredSkills,
                          Set<String> disqualifiedKeywords, Set<String> disqualifiedCompanies,
                          int preferredNoticePeriodDays) {
        this.title = title;
        this.company = company;
        this.minYearsExperience = minYearsExperience;
        this.maxYearsExperience = maxYearsExperience;
        this.targetLocations = targetLocations;
        this.requiredSkills = requiredSkills;
        this.preferredSkills = preferredSkills;
        this.disqualifiedKeywords = disqualifiedKeywords;
        this.disqualifiedCompanies = disqualifiedCompanies;
        this.preferredNoticePeriodDays = preferredNoticePeriodDays;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public double getMinYearsExperience() {
        return minYearsExperience;
    }

    public double getMaxYearsExperience() {
        return maxYearsExperience;
    }

    public Set<String> getTargetLocations() {
        return targetLocations;
    }

    public Set<String> getRequiredSkills() {
        return requiredSkills;
    }

    public Set<String> getPreferredSkills() {
        return preferredSkills;
    }

    public Set<String> getDisqualifiedKeywords() {
        return disqualifiedKeywords;
    }

    public Set<String> getDisqualifiedCompanies() {
        return disqualifiedCompanies;
    }

    public int getPreferredNoticePeriodDays() {
        return preferredNoticePeriodDays;
    }

    @Override
    public String toString() {
        return "JobDescription{" +
                "title='" + title + '\'' +
                ", experienceRange=[" + minYearsExperience + "-" + maxYearsExperience + "]" +
                ", requiredSkillsCount=" + (requiredSkills != null ? requiredSkills.size() : 0) +
                '}';
    }
}
