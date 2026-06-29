package com.ak.redrob.model;

/**
 * Represents a single career role (job experience) in a candidate's career history.
 */
public class Experience {

    private final String company;
    private final String title;
    private final String startDate;
    private final String endDate;
    private final int durationMonths;
    private final boolean isCurrent;
    private final String industry;
    private final String companySize;
    private final String description;

    public Experience(String company, String title, String startDate, String endDate,
                      int durationMonths, boolean isCurrent, String industry,
                      String companySize, String description) {
        this.company = company;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.durationMonths = durationMonths;
        this.isCurrent = isCurrent;
        this.industry = industry;
        this.companySize = companySize;
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public String getTitle() {
        return title;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public String getIndustry() {
        return industry;
    }

    public String getCompanySize() {
        return companySize;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "company='" + company + '\'' +
                ", title='" + title + '\'' +
                ", durationMonths=" + durationMonths +
                ", isCurrent=" + isCurrent +
                ", industry='" + industry + '\'' +
                ", companySize='" + companySize + '\'' +
                '}';
    }
}
