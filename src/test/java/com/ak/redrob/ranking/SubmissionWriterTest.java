package com.ak.redrob.ranking;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubmissionWriterTest {

    @Test
    void shouldWriteCsvCorrectly() throws Exception {

        SubmissionWriter writer =
                new SubmissionWriter();

        Path output =
                Files.createTempFile(
                        "submission",
                        ".csv"
                );

        List<RankedCandidate> candidates =

                List.of(

                        RankedCandidate.builder()

                                .candidateId("C001")

                                .rank(1)

                                .score(98.123456)

                                .reasoning("Excellent AI profile")

                                .build()

                );

        writer.write(
                output,
                candidates
        );

        assertTrue(
                Files.exists(output)
        );

        List<String> lines =
                Files.readAllLines(output);

        assertEquals(
                "candidate_id,rank,score,reasoning",
                lines.get(0)
        );

        assertTrue(
                lines.get(1).contains("98.1235")
        );

    }

}