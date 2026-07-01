package com.ak.redrob.parser;

import com.ak.redrob.model.Candidate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class CandidateParser {

    private static final Logger log =
            LoggerFactory.getLogger(CandidateParser.class);

    private static final int LOG_INTERVAL = 10_000;

    private final ObjectMapper mapper =
            JsonMapperConfig.objectMapper();

    public Stream<Candidate> parse(Path jsonlFile) {

        try {

            BufferedReader reader =
                    Files.newBufferedReader(jsonlFile);

            AtomicInteger counter =
                    new AtomicInteger();

            return reader.lines()

                    .map(line -> {

                        try {

                            Candidate candidate =
                                    mapper.readValue(
                                            line,
                                            Candidate.class
                                    );

                            int current =
                                    counter.incrementAndGet();

                            if (current % LOG_INTERVAL == 0) {

                                log.info(
                                        "Parsed {} candidates",
                                        current
                                );

                            }

                            return candidate;

                        }

                        catch (Exception e) {

                            log.warn(
                                    "Skipping malformed record: {}",
                                    e.getMessage()
                            );

                            return null;

                        }

                    })

                    .filter(java.util.Objects::nonNull)

                    .onClose(() -> {

                        try {

                            reader.close();

                        }

                        catch (IOException ignored) {
                        }

                    });

        }

        catch (IOException e) {

            throw new CandidateParserException(
                    "Unable to open JSONL file.",
                    e
            );

        }

    }

}