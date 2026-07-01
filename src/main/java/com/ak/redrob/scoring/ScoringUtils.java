package com.ak.redrob.scoring;

import com.ak.redrob.model.SkillProficiency;

import java.util.Set;

public final class ScoringUtils {

    private ScoringUtils() {}

    /**
     * AI keywords.
     */
    public static final Set<String> AI_SKILLS = Set.of(

            "embeddings",
            "vector search",
            "retrieval",
            "ranking",
            "nlp",
            "rag",
            "fine-tuning llms",
            "faiss",
            "pinecone",
            "weaviate",
            "qdrant",
            "milvus",
            "elasticsearch",
            "sentence-transformers",
            "recommendation systems",
            "evaluation frameworks",
            "ndcg",
            "mrr",
            "a/b testing"

    );

    /**
     * Non technical titles.
     */
    public static final Set<String> NON_TECHNICAL_TITLES = Set.of(

            "marketing manager",
            "hr manager",
            "accountant",
            "graphic designer",
            "content writer",
            "sales executive",
            "customer support",
            "operations manager"

    );

    public static double proficiencyMultiplier(
            SkillProficiency proficiency) {

        return switch (proficiency) {

            case BEGINNER -> 0.25;

            case INTERMEDIATE -> 0.50;

            case ADVANCED -> 0.80;

            case EXPERT -> 1.0;

        };

    }

    public static double endorsementMultiplier(
            int endorsements) {

        if (endorsements >= 50)
            return 1.30;

        if (endorsements >= 30)
            return 1.20;

        if (endorsements >= 10)
            return 1.10;

        return 1.0;

    }

    public static double durationMultiplier(
            int months) {

        if (months >= 36)
            return 1.15;

        if (months >= 24)
            return 1.10;

        if (months >= 12)
            return 1.05;

        return 1.0;

    }

}