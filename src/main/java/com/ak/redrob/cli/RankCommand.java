package com.ak.redrob.cli;

import com.ak.redrob.model.Candidate;
import com.ak.redrob.model.JobDescription;
import com.ak.redrob.model.ScoredCandidate;
import com.ak.redrob.parser.CandidateParser;
import com.ak.redrob.parser.HoneypotDetector;
import com.ak.redrob.parser.JobDescriptionLoader;
import com.ak.redrob.ranking.CandidateRanker;
import com.ak.redrob.ranking.HoneypotAuditReport;
import com.ak.redrob.ranking.PerformanceBenchmark;
import com.ak.redrob.ranking.RankedCandidate;
import com.ak.redrob.ranking.SubmissionWriter;
import com.ak.redrob.scoring.BehavioralReadinessScorer;
import com.ak.redrob.scoring.ExperienceScorer;
import com.ak.redrob.scoring.LocationScorer;
import com.ak.redrob.scoring.ScoringPipeline;
import com.ak.redrob.scoring.SignalScorer;
import com.ak.redrob.scoring.SkillMatchScorer;
import com.ak.redrob.scoring.TitleCareerScorer;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

/**
 * CLI command for ranking candidates.
 */
@Command(
        name = "redrob-ranker",
        description = "Rank candidates from JSONL against a job description",
        mixinStandardHelpOptions = true,
        version = "1.0.0"
)
public class RankCommand implements Callable<Integer> {

    @Option(
            names = {"-c", "--candidates"},
            description = "Candidates JSONL file",
            required = true
    )
    private Path candidatesPath;

    @Option(
            names = {"-j", "--jd"},
            description = "Job description file",
            required = true
    )
    private Path jobDescriptionPath;

    @Option(
            names = {"-o", "--out"},
            description = "Output CSV",
            defaultValue = "submission.csv"
    )
    private Path outputPath;

    @Option(
            names = {"-k", "--top-k"},
            description = "Number of candidates to return",
            defaultValue = "100"
    )
    private int topK;

    @Option(
            names = {"-t", "--threads"},
            description = "Parallelism level",
            defaultValue = "${sys:java.util.concurrent.ForkJoinPool.common.parallelism:-1}"
    )
    private int threads;

    @Option(
            names = {"-v", "--verbose"},
            description = "Print top candidate reasoning"
    )
    private boolean verbose;

    @Override
    public Integer call() throws Exception {

        PerformanceBenchmark benchmark =
                new PerformanceBenchmark();

        benchmark.startTotal();

        benchmark.startIngestion();

        CandidateParser parser =
                new CandidateParser();

        JobDescriptionLoader loader =
                new JobDescriptionLoader();

        JobDescription jd =
                loader.load(jobDescriptionPath);

        benchmark.endIngestion();

        List<SignalScorer> scorers = List.of(

                new SkillMatchScorer(),

                new TitleCareerScorer(),

                new ExperienceScorer(),

                new LocationScorer()

        );

        ScoringPipeline pipeline =
                new ScoringPipeline(

                        scorers,

                        new BehavioralReadinessScorer(),

                        new HoneypotDetector()

                );

        CandidateRanker ranker =
                new CandidateRanker();

        benchmark.startScoring();

        Stream<ScoredCandidate> scoredStream =

                parser

                        .parse(candidatesPath)

                        .parallel()

                        .map(candidate ->

                                pipeline.score(candidate, jd)

                        );

        benchmark.endScoring();

        benchmark.startRanking();

        List<RankedCandidate> ranked =

                ranker.rank(scoredStream);

        benchmark.endRanking();

        SubmissionWriter writer =
                new SubmissionWriter();

        writer.write(outputPath, ranked);

        new HoneypotAuditReport()

                .audit(ranked, 0);

        benchmark.finish(ranked.size());

        if (verbose) {

            System.out.println();

            System.out.println("===== TOP 10 =====");

            ranked.stream()

                    .limit(10)

                    .forEach(candidate -> {

                        System.out.printf(

                                "#%02d  %-12s  %.4f%n",

                                candidate.rank(),

                                candidate.candidateId(),

                                candidate.score()

                        );

                        System.out.println(

                                "    "

                                        + candidate.reasoning()

                        );

                    });

        }

        System.out.println();

        System.out.println("Submission written to:");

        System.out.println(outputPath.toAbsolutePath());

        return 0;

    }

}