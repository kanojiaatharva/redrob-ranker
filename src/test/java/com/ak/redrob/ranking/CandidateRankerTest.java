package com.ak.redrob.ranking;

import com.ak.redrob.model.Candidate;
import com.ak.redrob.model.CandidateProfile;
import com.ak.redrob.model.ScoredCandidate;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class CandidateRankerTest {

    @Test
    void shouldReturnTopFiveCandidates() {

        CandidateRanker ranker = new CandidateRanker();

        List<ScoredCandidate> candidates =

                IntStream.rangeClosed(1, 200)

                        .mapToObj(i ->

                                ScoredCandidate.builder()

                                        .candidate(createCandidate("C%03d".formatted(i)))

                                        .totalScore(i)

                                        .componentScores(Map.of())

                                        .reasoning("Candidate " + i)

                                        .build()

                        )

                        .toList();

        List<RankedCandidate> ranked =
                ranker.rank(candidates.stream());

        assertEquals(100, ranked.size());

        assertEquals("C200", ranked.get(0).candidateId());

        assertEquals("C199", ranked.get(1).candidateId());

        assertEquals("C198", ranked.get(2).candidateId());

        assertEquals(1, ranked.get(0).rank());

    }

    private Candidate createCandidate(String id) {

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