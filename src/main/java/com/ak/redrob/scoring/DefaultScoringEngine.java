package com.ak.redrob.scoring;

import com.ak.redrob.engine.ScoringEngine;
import com.ak.redrob.model.Candidate;
import com.ak.redrob.model.CandidateScore;
import com.ak.redrob.model.JobDescription;
import com.ak.redrob.scoring.strategy.*;

public class DefaultScoringEngine implements ScoringEngine {

    private final SkillScorer skillScorer =
            new SkillScorer();

    private final ExperienceScorer experienceScorer =
            new ExperienceScorer();

    private final EducationScorer educationScorer =
            new EducationScorer();

    private final KeywordScorer keywordScorer =
            new KeywordScorer();

    private final BehavioralScorer behavioralScorer =
            new BehavioralScorer();

    @Override
    public CandidateScore score(Candidate candidate,
                                JobDescription job) {

        ScoreBreakdown breakdown =
                new ScoreBreakdown();

        double skill =
                skillScorer.score(candidate, job);

        double experience =
                experienceScorer.score(candidate, job);

        double education =
                educationScorer.score(candidate, job);

        double keyword =
                keywordScorer.score(candidate, job);

        double behavioral =
                behavioralScorer.score(candidate);

        breakdown.add(
                ScoreComponent.SKILLS,
                skill * 100 * ScoreWeights.SKILL);

        breakdown.add(
                ScoreComponent.EXPERIENCE,
                experience * 100 * ScoreWeights.EXPERIENCE);

        breakdown.add(
                ScoreComponent.EDUCATION,
                education * 100 * ScoreWeights.EDUCATION);

        breakdown.add(
                ScoreComponent.KEYWORDS,
                keyword * 100 * ScoreWeights.KEYWORDS);

        breakdown.add(
                ScoreComponent.BEHAVIORAL,
                behavioral * 100 * ScoreWeights.BEHAVIORAL);

        return new CandidateScore(
                candidate,
                breakdown.total(),
                breakdown
        );

    }

}
