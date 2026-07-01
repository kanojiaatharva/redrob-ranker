package com.ak.redrob.preprocessing;

import java.util.Arrays;
import java.util.List;

public final class Tokenizer {

    private Tokenizer() {
    }

    public static List<String> tokenize(String text) {

        return Arrays.stream(TextNormalizer.normalize(text).split(" "))
                .filter(s -> !s.isBlank())
                .toList();

    }

}
