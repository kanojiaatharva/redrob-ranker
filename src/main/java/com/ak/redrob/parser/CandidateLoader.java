package com.ak.redrob.parser;

import com.ak.redrob.model.Candidate;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface CandidateLoader {

    Stream<Candidate> load(Path path) throws IOException;

}