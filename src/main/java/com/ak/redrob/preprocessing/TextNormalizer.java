package com.ak.redrob.preprocessing;

public final class TextNormalizer {

    private TextNormalizer() {
    }

    public static String normalize(String text) {

        if (text == null) {
            return "";
        }

        return text
                .toLowerCase()
                .replaceAll("[^a-z0-9 ]", " ")
                .replaceAll("\\s+", " ")
                .trim();
    }
}
