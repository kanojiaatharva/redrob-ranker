package com.ak.redrob.ranking;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Writes ranked candidates into submission CSV.
 */
public class SubmissionWriter {

    private static final DecimalFormat FORMAT =
            new DecimalFormat("0.0000");

    public void write(
            Path output,
            List<RankedCandidate> rankedCandidates)
            throws IOException {

        validate(rankedCandidates);

        try (

                CSVWriter writer = new CSVWriter(

                        new FileWriter(output.toFile()),

                        CSVWriter.DEFAULT_SEPARATOR,

                        CSVWriter.NO_QUOTE_CHARACTER,

                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,

                        CSVWriter.DEFAULT_LINE_END

                )

        ) {

            writer.writeNext(new String[]{
                    "candidate_id",
                    "rank",
                    "score",
                    "reasoning"
            });

            for (RankedCandidate candidate : rankedCandidates) {

                writer.writeNext(

                        new String[]{

                                candidate.candidateId(),

                                String.valueOf(candidate.rank()),

                                FORMAT.format(candidate.score()),

                                candidate.reasoning()

                        }

                );

            }

        }

        printSummary(rankedCandidates);

    }

    private void validate(
            List<RankedCandidate> ranked) {

        Set<String> ids =
                new HashSet<>();

        double previous =
                Double.MAX_VALUE;

        int expectedRank = 1;

        for (RankedCandidate candidate : ranked) {

            if (candidate.rank() != expectedRank++) {

                throw new IllegalStateException(
                        "Ranks are not sequential."
                );

            }

            if (candidate.score() > previous) {

                throw new IllegalStateException(
                        "Scores must be descending."
                );

            }

            previous = candidate.score();

            if (!ids.add(candidate.candidateId())) {

                throw new IllegalStateException(
                        "Duplicate candidate id: "
                                + candidate.candidateId()
                );

            }

        }

    }

    private void printSummary(
            List<RankedCandidate> ranked) {

        System.out.println();

        System.out.println("========== TOP 10 ==========");

        ranked.stream()

                .limit(10)

                .forEach(candidate ->

                        System.out.printf(

                                "#%02d %-10s %.4f%n",

                                candidate.rank(),

                                candidate.candidateId(),

                                candidate.score()

                        ));

        System.out.println("============================");

    }

}