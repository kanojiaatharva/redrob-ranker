package com.ak.redrob.scoring;

import com.ak.redrob.model.*;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Scores AI skill alignment.
 */
public class SkillMatchScorer
        implements SignalScorer {

    @Override
    public String getName() {

        return "Skill Match";

    }

    @Override
    public double getWeight() {

        return ScoringWeights.SKILL;

    }

    @Override
    public double score(Candidate candidate,
                        JobDescription jd) {

        Set<String> matched =
                new HashSet<>();

        double total = 0;

        for (Skill skill : candidate.skills()) {

            String name =
                    skill.name()
                            .toLowerCase(Locale.ROOT);

            if (!ScoringUtils.AI_SKILLS.contains(name))
                continue;

            matched.add(name);

            double score =
                    ScoringUtils.proficiencyMultiplier(
                            skill.proficiency());

            score *=
                    ScoringUtils.endorsementMultiplier(
                            skill.endorsements());

            score *=
                    ScoringUtils.durationMultiplier(
                            skill.durationMonths());

            total += score;

        }

        // Resume summary scan

        String summary =
                candidate.profile()
                        .summary()
                        .toLowerCase();

        for (String keyword :
                ScoringUtils.AI_SKILLS) {

            if (summary.contains(keyword))
                matched.add(keyword);

        }

        // Career description scan

        for (CareerEntry job :
                candidate.careerHistory()) {

            String desc =
                    job.description() == null
                            ? ""
                            : job.description().toLowerCase();

            for (String keyword :
                    ScoringUtils.AI_SKILLS) {

                if (desc.contains(keyword))
                    matched.add(keyword);

            }

        }

        total += matched.size() * 0.25;

        total /=
                jd.requiredSkills().size();

        total =
                Math.min(1.0, total);

        // Keyword stuffing detection

        String title =
                candidate.profile()
                        .currentTitle()
                        .toLowerCase();

        if (candidate.skills().size() >= 15
                &&
                ScoringUtils.NON_TECHNICAL_TITLES
                        .contains(title)) {

            total *= 0.50;

        }

        return total;

    }

}