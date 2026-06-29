package com.ak.redrob.parser;

import com.ak.redrob.model.Candidate;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public class JsonlCandidateLoader implements CandidateLoader {

    @Override
    public Stream<Candidate> load(Path path) throws IOException {

        throw new UnsupportedOperationException(
                "Implementation added in Step 4"
        );

    }

}