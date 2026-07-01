package com.ak.redrob;

import com.ak.redrob.cli.RankCommand;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EndToEndIT {

    @Test
    void shouldGenerateSubmissionCsv() throws Exception {

        Path candidates = Path.of(
                "src",
                "test",
                "resources",
                "sample_candidates.jsonl"
        );

        Path jd = Path.of(
                "src",
                "test",
                "resources",
                "sample_job_description.txt"
        );

        Path output =
                Files.createTempFile(
                        "submission",
                        ".csv"
                );

        int exitCode =

                new CommandLine(
                        new RankCommand()
                )

                        .execute(

                                "--candidates",
                                candidates.toString(),

                                "--jd",
                                jd.toString(),

                                "--out",
                                output.toString()

                        );

        assertEquals(0, exitCode);

        assertTrue(Files.exists(output));

        List<String> lines =
                Files.readAllLines(output);

        // Header

        assertEquals(

                "candidate_id,rank,score,reasoning",

                lines.get(0)

        );

        // At least one candidate

        assertTrue(lines.size() > 1);

        // Validate sequential ranks

        double previousScore =
                Double.MAX_VALUE;

        for (int i = 1; i < lines.size(); i++) {

            String[] cols =
                    lines.get(i).split(",", 4);

            assertEquals(
                    i,
                    Integer.parseInt(cols[1])
            );

            double score =
                    Double.parseDouble(cols[2]);

            assertTrue(
                    score <= previousScore
            );

            previousScore = score;

        }

    }

}