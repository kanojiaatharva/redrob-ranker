package com.ak.redrob.ranking;

import com.ak.redrob.model.Candidate;
import com.ak.redrob.model.CandidateProfile;
import com.ak.redrob.model.ScoredCandidate;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TieBreakingTest {

    @Test
    void shouldBreakTieUsingCandidateId() {

        CandidateRanker ranker = new CandidateRanker();

        ScoredCandidate first =

                ScoredCandidate.builder()

                        .candidate(candidate("C002"))

                        .totalScore(95)

                        .componentScores(Map.of())

                        .reasoning("")

                        .build();

        ScoredCandidate second =

                ScoredCandidate.builder()

                        .candidate(candidate("C001"))

                        .totalScore(95)

                        .componentScores(Map.of())

                        .reasoning("")

                        .build();

        List<RankedCandidate> ranked =

                ranker.rank(
                        List.of(first, second).stream()
                );

        assertEquals(
                "C001",
                ranked.get(0).candidateId()
        );

        assertEquals(
                "C002",
                ranked.get(1).candidateId()
        );

    }

    private Candidate candidate(String id) {

        return Candidate.builder()

                .candidateId(id)

                .profile(
                        CandidateProfile.builder()
                                .anonymizedName(id)
                                .headline("")
                                .summary("")
                                .location("")
                                .country("")
                                .yearsOfExperience(5)
                                .currentTitle("AI Engineer")
                                .currentCompany("")
                                .currentCompanySize("")
                                .currentIndustry("")
                                .build()
                )

                .careerHistory(Collections.emptyList())

                .education(Collections.emptyList())

                .skills(Collections.emptyList())

                .certifications(Collections.emptyList())

                .languages(Collections.emptyList())

                .redrobSignals(null)

                .build();

    }

}