package com.ak.redrob.scoring;

import com.ak.redrob.model.Candidate;
import com.ak.redrob.model.JobDescription;
import com.ak.redrob.model.ScoredCandidate;
import com.ak.redrob.parser.HoneypotDetector;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Executes all scoring signals and produces the final score.
 */
public class ScoringPipeline {

    private final List<SignalScorer> scorers;

    private final BehavioralReadinessScorer behavioralScorer;

    private final HoneypotDetector honeypotDetector;

    public ScoringPipeline(
            List<SignalScorer> scorers,
            BehavioralReadinessScorer behavioralScorer,
            HoneypotDetector honeypotDetector) {

        this.scorers = scorers;
        this.behavioralScorer = behavioralScorer;
        this.honeypotDetector = honeypotDetector;

    }

    /**
     * Scores a single candidate.
     */
    public ScoredCandidate score(
            Candidate candidate,
            JobDescription jobDescription) {

        // Honeypot detection

        if (honeypotDetector.isHoneypot(candidate)) {

            return ScoredCandidate.builder()

                    .candidate(candidate)

                    .totalScore(0.0)

                    .componentScores(Map.of())

                    .reasoning("Rejected: Honeypot / synthetic profile")

                    .build();

        }

        Map<String, Double> componentScores =
                new LinkedHashMap<>();

        double weightedScore = 0;

        for (SignalScorer scorer : scorers) {

            double score =
                    scorer.score(candidate, jobDescription);

            componentScores.put(
                    scorer.getName(),
                    score
            );

            weightedScore +=
                    score * scorer.getWeight();

        }

        double behavioralModifier =
                behavioralScorer.modifier(candidate);

        componentScores.put(
                "Behavioral Modifier",
                behavioralModifier
        );

        double finalScore =
                weightedScore * behavioralModifier;

        finalScore =
                Math.max(
                        0,
                        Math.min(finalScore, 1.5)
                );

        return ScoredCandidate.builder()

                .candidate(candidate)

                .totalScore(finalScore)

                .componentScores(componentScores)

                .reasoning(
                        buildReasoning(
                                candidate,
                                behavioralModifier
                        )
                )

                .build();

    }

    /**
     * Scores candidates in parallel.
     */
    public List<ScoredCandidate> scoreAll(

            List<Candidate> candidates,

            JobDescription jobDescription) {

        return candidates

                .parallelStream()

                .map(candidate ->
                        score(candidate, jobDescription))

                .collect(Collectors.toList());

    }

    /**
     * Creates explanation string.
     */
    private String buildReasoning(

            Candidate candidate,

            double modifier) {

        long aiSkills =

                candidate.skills()

                        .stream()

                        .filter(skill ->
                                ScoringUtils.AI_SKILLS.contains(
                                        skill.name()
                                                .toLowerCase()))

                        .count();

        String insight;

        if (aiSkills >= 8)

            insight = "Strong AI profile";

        else if (aiSkills >= 5)

            insight = "Good technical match";

        else

            insight = "Limited AI experience";

        return String.format(

                "%s | %.1fyr exp | %d AI skills matched | Behavioral: %.2fx | %s",

                candidate.profile().currentTitle(),

                candidate.profile().yearsOfExperience(),

                aiSkills,

                modifier,

                insight

        );

    }

}