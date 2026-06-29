package com.ak.redrob.parser;

import com.ak.redrob.model.Candidate;
import com.ak.redrob.exception.RankingException;

import java.io.File;
import java.io.InputStream;
import java.util.stream.Stream;

/**
 * Interface contract for loading and parsing candidate profiles from files or input streams.
 */
public interface CandidateLoader {

    /**
     * Parses a stream of candidate records from a gzipped or plain text JSONL input stream.
     *
     * @param inputStream the source input stream
     * @return a Stream of parsed Candidates
     * @throws RankingException if parser or resource access fails
     */
    Stream<Candidate> loadCandidates(InputStream inputStream) throws RankingException;

    /**
     * Parses candidate records from a local file.
     *
     * @param file the source file (.jsonl or .jsonl.gz)
     * @return a Stream of parsed Candidates
     * @throws RankingException if parsing fails
     */
    Stream<Candidate> loadCandidates(File file) throws RankingException;
}
