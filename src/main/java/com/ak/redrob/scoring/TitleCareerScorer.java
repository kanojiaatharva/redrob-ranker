package com.ak.redrob.scoring;

import com.ak.redrob.model.Candidate;
import com.ak.redrob.model.CareerEntry;
import com.ak.redrob.model.JobDescription;

import java.util.List;
import java.util.Locale;
import java.util.Set;

public class TitleCareerScorer implements SignalScorer {

    private static final Set<String> TARGET = Set.of(
            "ai engineer",
            "ml engineer",
            "machine learning engineer",
            "nlp engineer",
            "applied scientist",
            "research engineer"
    );

    private static final Set<String> ADJACENT = Set.of(
            "data scientist",
            "backend engineer",
            "software engineer",
            "data engineer"
    );

    private static final Set<String> CONSULTING = Set.of(
            "tcs",
            "infosys",
            "wipro",
            "accenture",
            "cognizant",
            "capgemini"
    );

    @Override
    public String getName() {
        return "Title Career";
    }

    @Override
    public double getWeight() {
        return ScoringWeights.TITLE;
    }

    @Override
    public double score(Candidate candidate,
                        JobDescription jd) {

        double score =
                evaluate(candidate.profile().currentTitle());

        List<CareerEntry> history =
                candidate.careerHistory();

        int limit =
                Math.min(3, history.size());

        for (int i = 0; i < limit; i++) {

            score = Math.max(
                    score,
                    evaluate(history.get(i).title())
            );

        }

        boolean consultingOnly =
                history.stream()
                        .allMatch(job -> CONSULTING.contains(
                                job.company().toLowerCase(Locale.ROOT)));

        if (consultingOnly && !history.isEmpty())
            score *= 0.30;

        boolean productCompany =
                history.stream()
                        .anyMatch(job ->
                                !CONSULTING.contains(
                                        job.company()
                                                .toLowerCase(Locale.ROOT)));

        if (productCompany)
            score *= 1.10;

        return Math.min(score, 1.0);

    }

    private double evaluate(String title) {

        if (title == null)
            return 0;

        String t =
                title.toLowerCase(Locale.ROOT);

        if (ScoringUtils.NON_TECHNICAL_TITLES.contains(t))
            return 0.05;

        if (TARGET.contains(t))
            return 1.0;

        if (ADJACENT.contains(t))
            return 0.60;

        if ((t.contains("senior")
                || t.contains("lead")
                || t.contains("staff")
                || t.contains("principal"))
                &&
                (t.contains("engineer")
                        || t.contains("scientist")))
            return 0.80;

        return 0.20;

    }

}