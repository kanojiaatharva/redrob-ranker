package com.ak.redrob.model;

import java.util.List;
import java.util.Map;

/**
 * Represents a full candidate profile loaded from the Redrob platform.
 */
public class Candidate {

    public static class Profile {
        private final String anonymizedName;
        private final String headline;
        private final String summary;
        private final String location;
        private final String country;
        private final double yearsOfExperience;
        private final String currentTitle;
        private final String currentCompany;
        private final String currentCompanySize;
        private final String currentIndustry;

        public Profile(String anonymizedName, String headline, String summary, String location, String country,
                       double yearsOfExperience, String currentTitle, String currentCompany,
                       String currentCompanySize, String currentIndustry) {
            this.anonymizedName = anonymizedName;
            this.headline = headline;
            this.summary = summary;
            this.location = location;
            this.country = country;
            this.yearsOfExperience = yearsOfExperience;
            this.currentTitle = currentTitle;
            this.currentCompany = currentCompany;
            this.currentCompanySize = currentCompanySize;
            this.currentIndustry = currentIndustry;
        }

        public String getAnonymizedName() { return anonymizedName; }
        public String getHeadline() { return headline; }
        public String getSummary() { return summary; }
        public String getLocation() { return location; }
        public String getCountry() { return country; }
        public double getYearsOfExperience() { return yearsOfExperience; }
        public String getCurrentTitle() { return currentTitle; }
        public String getCurrentCompany() { return currentCompany; }
        public String getCurrentCompanySize() { return currentCompanySize; }
        public String getCurrentIndustry() { return currentIndustry; }
    }

    public static class SalaryRange {
        private final double min;
        private final double max;

        public SalaryRange(double min, double max) {
            this.min = min;
            this.max = max;
        }

        public double getMin() { return min; }
        public double getMax() { return max; }
    }

    public static class RedrobSignals {
        private final double profileCompletenessScore;
        private final String signupDate;
        private final String lastActiveDate;
        private final boolean openToWorkFlag;
        private final int profileViewsReceived30d;
        private final int applicationsSubmitted30d;
        private final double recruiterResponseRate;
        private final double avgResponseTimeHours;
        private final Map<String, Double> skillAssessmentScores;
        private final int connectionCount;
        private final int endorsementsReceived;
        private final int noticePeriodDays;
        private final SalaryRange expectedSalaryRangeInrLpa;
        private final String preferredWorkMode;
        private final boolean willingToRelocate;
        private final double githubActivityScore;
        private final int searchAppearance30d;
        private final int savedByRecruiters30d;
        private final double interviewCompletionRate;
        private final double offerAcceptanceRate;
        private final boolean verifiedEmail;
        private final boolean verifiedPhone;
        private final boolean linkedinConnected;

        public RedrobSignals(double profileCompletenessScore, String signupDate, String lastActiveDate,
                             boolean openToWorkFlag, int profileViewsReceived30d, int applicationsSubmitted30d,
                             double recruiterResponseRate, double avgResponseTimeHours,
                             Map<String, Double> skillAssessmentScores, int connectionCount, int endorsementsReceived,
                             int noticePeriodDays, SalaryRange expectedSalaryRangeInrLpa, String preferredWorkMode,
                             boolean willingToRelocate, double githubActivityScore, int searchAppearance30d,
                             int savedByRecruiters30d, double interviewCompletionRate, double offerAcceptanceRate,
                             boolean verifiedEmail, boolean verifiedPhone, boolean linkedinConnected) {
            this.profileCompletenessScore = profileCompletenessScore;
            this.signupDate = signupDate;
            this.lastActiveDate = lastActiveDate;
            this.openToWorkFlag = openToWorkFlag;
            this.profileViewsReceived30d = profileViewsReceived30d;
            this.applicationsSubmitted30d = applicationsSubmitted30d;
            this.recruiterResponseRate = recruiterResponseRate;
            this.avgResponseTimeHours = avgResponseTimeHours;
            this.skillAssessmentScores = skillAssessmentScores;
            this.connectionCount = connectionCount;
            this.endorsementsReceived = endorsementsReceived;
            this.noticePeriodDays = noticePeriodDays;
            this.expectedSalaryRangeInrLpa = expectedSalaryRangeInrLpa;
            this.preferredWorkMode = preferredWorkMode;
            this.willingToRelocate = willingToRelocate;
            this.githubActivityScore = githubActivityScore;
            this.searchAppearance30d = searchAppearance30d;
            this.savedByRecruiters30d = savedByRecruiters30d;
            this.interviewCompletionRate = interviewCompletionRate;
            this.offerAcceptanceRate = offerAcceptanceRate;
            this.verifiedEmail = verifiedEmail;
            this.verifiedPhone = verifiedPhone;
            this.linkedinConnected = linkedinConnected;
        }

        public double getProfileCompletenessScore() { return profileCompletenessScore; }
        public String getSignupDate() { return signupDate; }
        public String getLastActiveDate() { return lastActiveDate; }
        public boolean isOpenToWorkFlag() { return openToWorkFlag; }
        public int getProfileViewsReceived30d() { return profileViewsReceived30d; }
        public int getApplicationsSubmitted30d() { return applicationsSubmitted30d; }
        public double getRecruiterResponseRate() { return recruiterResponseRate; }
        public double getAvgResponseTimeHours() { return avgResponseTimeHours; }
        public Map<String, Double> getSkillAssessmentScores() { return skillAssessmentScores; }
        public int getConnectionCount() { return connectionCount; }
        public int getEndorsementsReceived() { return endorsementsReceived; }
        public int getNoticePeriodDays() { return noticePeriodDays; }
        public SalaryRange getExpectedSalaryRangeInrLpa() { return expectedSalaryRangeInrLpa; }
        public String getPreferredWorkMode() { return preferredWorkMode; }
        public boolean isWillingToRelocate() { return willingToRelocate; }
        public double getGithubActivityScore() { return githubActivityScore; }
        public int getSearchAppearance30d() { return searchAppearance30d; }
        public int getSavedByRecruiters30d() { return savedByRecruiters30d; }
        public double getInterviewCompletionRate() { return interviewCompletionRate; }
        public double getOfferAcceptanceRate() { return offerAcceptanceRate; }
        public boolean isVerifiedEmail() { return verifiedEmail; }
        public boolean isVerifiedPhone() { return verifiedPhone; }
        public boolean isLinkedinConnected() { return linkedinConnected; }
    }

    public static class Certification {
        private final String name;
        private final String issuer;
        private final int year;

        public Certification(String name, String issuer, int year) {
            this.name = name;
            this.issuer = issuer;
            this.year = year;
        }

        public String getName() { return name; }
        public String getIssuer() { return issuer; }
        public int getYear() { return year; }
    }

    public static class Language {
        private final String language;
        private final String proficiency;

        public Language(String language, String proficiency) {
            this.language = language;
            this.proficiency = proficiency;
        }

        public String getLanguage() { return language; }
        public String getProficiency() { return proficiency; }
    }

    private final String candidateId;
    private final Profile profile;
    private final List<Experience> careerHistory;
    private final List<Education> education;
    private final List<Skill> skills;
    private final List<Certification> certifications;
    private final List<Language> languages;
    private final RedrobSignals redrobSignals;

    public Candidate(String candidateId, Profile profile, List<Experience> careerHistory,
                     List<Education> education, List<Skill> skills, List<Certification> certifications,
                     List<Language> languages, RedrobSignals redrobSignals) {
        this.candidateId = candidateId;
        this.profile = profile;
        this.careerHistory = careerHistory;
        this.education = education;
        this.skills = skills;
        this.certifications = certifications;
        this.languages = languages;
        this.redrobSignals = redrobSignals;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<Experience> getCareerHistory() {
        return careerHistory;
    }

    public List<Education> getEducation() {
        return education;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public List<Certification> getCertifications() {
        return certifications;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public RedrobSignals getRedrobSignals() {
        return redrobSignals;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateId='" + candidateId + '\'' +
                ", profile=" + (profile != null ? profile.getCurrentTitle() : "null") +
                ", careerHistoryCount=" + (careerHistory != null ? careerHistory.size() : 0) +
                ", skillsCount=" + (skills != null ? skills.size() : 0) +
                '}';
    }
}
