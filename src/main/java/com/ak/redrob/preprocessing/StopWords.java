package com.ak.redrob.preprocessing;

import java.util.Set;

public final class StopWords {

    private StopWords() {}

    public static final Set<String> WORDS = Set.of(

            "a",
            "an",
            "the",
            "is",
            "are",
            "was",
            "were",
            "to",
            "of",
            "for",
            "and",
            "or",
            "with",
            "on",
            "in",
            "at",
            "by"

    );

}
