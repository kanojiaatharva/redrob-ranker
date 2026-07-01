package com.ak.redrob.parser;

import com.ak.redrob.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HoneypotDetectorTest {

    @Test
    void shouldDetectImpossibleExpertSkills() {

        Skill expert =
                Skill.builder()
                        .name("Java")
                        .proficiency(SkillProficiency.EXPERT)
                        .durationMonths(0)
                        .endorsements(10)
                        .build();

        Candidate candidate =
                Candidate.builder()

                        .candidateId("1")

                        .profile(
                                CandidateProfile.builder()
                                        .yearsOfExperience(8)
                                        .build()
                        )

                        .careerHistory(List.of())

                        .education(List.of())

                        .skills(List.of(
                                expert, expert, expert, expert, expert,
                                expert, expert, expert, expert, expert
                        ))

                        .certifications(List.of())

                        .languages(List.of())

                        .redrobSignals(
                                RedrobSignals.builder()
                                        .profileCompletenessScore(95)
                                        .skillAssessmentScores(Map.of())
                                        .build()
                        )

                        .build();

        HoneypotDetector detector =
                new HoneypotDetector();

        assertTrue(detector.isHoneypot(candidate));

    }

    @Test
    void shouldPassValidCandidate() {

        Candidate candidate =
                Candidate.builder()

                        .candidateId("2")

                        .profile(
                                CandidateProfile.builder()
                                        .yearsOfExperience(6)
                                        .build()
                        )

                        .careerHistory(List.of())

                        .education(List.of(
                                Education.builder()
                                        .institution("IIT")
                                        .degree("B.Tech")
                                        .fieldOfStudy("CSE")
                                        .startYear(2015)
                                        .endYear(2019)
                                        .grade("8.5")
                                        .tier(EducationTier.TIER_1)
                                        .build()
                        ))

                        .skills(List.of(
                                Skill.builder()
                                        .name("Java")
                                        .proficiency(
                                                SkillProficiency.ADVANCED
                                        )
                                        .durationMonths(60)
                                        .endorsements(25)
                                        .build()
                        ))

                        .certifications(List.of())

                        .languages(List.of())

                        .redrobSignals(

                                RedrobSignals.builder()

                                        .profileCompletenessScore(95)

                                        .signupDate(
                                                LocalDate.now()
                                                        .minusYears(5)
                                        )

                                        .skillAssessmentScores(
                                                Map.of("Java", 90.0)
                                        )

                                        .build()

                        )

                        .build();

        HoneypotDetector detector =
                new HoneypotDetector();

        assertFalse(detector.isHoneypot(candidate));

    }

}