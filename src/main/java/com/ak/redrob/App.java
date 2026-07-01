package com.ak.redrob;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;

@Command(
        name = "redrob-ranker",
        mixinStandardHelpOptions = true,
        version = "1.0.0",
        description = "AI Candidate Ranking Engine"
)
public class App implements Runnable {

    @Option(
            names = "--candidates",
            required = true,
            description = "Path to candidates JSONL"
    )
    private File candidates;

    @Option(
            names = "--jd",
            required = true,
            description = "Path to job description"
    )
    private File jobDescription;

    @Option(
            names = "--out",
            required = true,
            description = "Output CSV"
    )
    private File output;

    @Override
    public void run() {

        System.out.println("Candidates : " + candidates);

        System.out.println("Job : " + jobDescription);

        System.out.println("Output : " + output);

        /*
         * Later:
         *
         * JobDescription jd =
         *      JobDescriptionLoader.load(jobDescription.toPath());
         *
         * RankingPipeline pipeline =
         *      new RankingPipeline();
         *
         * pipeline.execute(
         *      candidates.toPath(),
         *      jd,
         *      output.toPath()
         * );
         */

    }

    public static void main(String[] args) {

        int exitCode =
                new CommandLine(new App())
                        .execute(args);

        System.exit(exitCode);

    }

}