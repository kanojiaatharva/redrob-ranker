package com.ak.redrob.ranking;

/**
 * Measures execution time
 * for every pipeline stage.
 */
public class PerformanceBenchmark {

    private long ingestionStart;

    private long scoringStart;

    private long rankingStart;

    private long totalStart;

    public void startTotal() {

        totalStart = System.nanoTime();

    }

    public void startIngestion() {

        ingestionStart = System.nanoTime();

    }

    public void endIngestion() {

        log("Ingestion", ingestionStart);

    }

    public void startScoring() {

        scoringStart = System.nanoTime();

    }

    public void endScoring() {

        log("Scoring", scoringStart);

    }

    public void startRanking() {

        rankingStart = System.nanoTime();

    }

    public void endRanking() {

        log("Ranking", rankingStart);

    }

    /**
     * Prints final benchmark.
     */
    public void finish(int candidatesProcessed) {

        long elapsed =
                System.nanoTime() - totalStart;

        double seconds =
                elapsed / 1_000_000_000.0;

        double throughput =
                candidatesProcessed / seconds;

        System.out.println();

        System.out.println(
                "========= PERFORMANCE ========="
        );

        System.out.printf(
                "Candidates Processed : %,d%n",
                candidatesProcessed
        );

        System.out.printf(
                "Total Time           : %.2f sec%n",
                seconds
        );

        System.out.printf(
                "Throughput           : %,.0f candidates/sec%n",
                throughput
        );

        if (seconds < 300) {

            System.out.println(
                    "PASS (< 5 minutes)"
            );

        } else {

            System.out.println(
                    "FAIL (> 5 minutes)"
            );

        }

        System.out.println(
                "==============================="
        );

    }

    private void log(
            String stage,
            long start) {

        double seconds =
                (System.nanoTime() - start)
                        / 1_000_000_000.0;

        System.out.printf(
                "%-12s : %.3f sec%n",
                stage,
                seconds
        );

    }

}