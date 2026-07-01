package com.ak.redrob.preprocessing;

import java.util.List;

public class ResumePreprocessor {

    public List<String> preprocess(String resume) {

        return Tokenizer.tokenize(resume)
                .stream()
                .filter(word -> !StopWords.WORDS.contains(word))
                .toList();

    }

}
