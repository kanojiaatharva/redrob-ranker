package com.ak.redrob.ranking;

import com.ak.redrob.model.ScoredCandidate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

/**
 * Maintains Top-K candidates using a bounded min-heap.
 *
 * Complexity:
 * O(N log K)
 *
 * Memory:
 * O(K)
 */
public class CandidateRanker {

    private static final int TOP_K = 100;

    /**
     * Worst candidate first.
     */
    private static final Comparator<ScoredCandidate> MIN_HEAP_COMPARATOR =
            Comparator
                    .comparingDouble(ScoredCandidate::totalScore)
                    .thenComparing(
                            c -> c.candidate().candidateId(),
                            Comparator.reverseOrder()
                    );

    /**
     * Best candidate first.
     */
    private static final Comparator<ScoredCandidate> FINAL_COMPARATOR =
            Comparator
                    .comparingDouble(ScoredCandidate::totalScore)
                    .reversed()
                    .thenComparing(
                            c -> c.candidate().candidateId()
                    );

    /**
     * Returns ranked Top-K candidates.
     */
    public List<RankedCandidate> rank(Stream<ScoredCandidate> candidates) {

        PriorityQueue<ScoredCandidate> heap =
                new PriorityQueue<>(TOP_K, MIN_HEAP_COMPARATOR);

        candidates.forEach(candidate -> {

            if (heap.size() < TOP_K) {

                heap.offer(candidate);

            } else if (MIN_HEAP_COMPARATOR.compare(candidate, heap.peek()) > 0) {

                heap.poll();

                heap.offer(candidate);

            }

        });

        List<ScoredCandidate> best =
                new ArrayList<>(heap);

        best.sort(FINAL_COMPARATOR);

        List<RankedCandidate> ranked =
                new ArrayList<>();

        int rank = 1;

        for (ScoredCandidate candidate : best) {

            ranked.add(

                    RankedCandidate.builder()

                            .candidateId(
                                    candidate.candidate().candidateId()
                            )

                            .rank(rank++)

                            .score(candidate.totalScore())

                            .reasoning(candidate.reasoning())

                            .build()

            );

        }

        return ranked;

    }

}