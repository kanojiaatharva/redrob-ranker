package com.ak.redrob.engine;

import com.ak.redrob.model.CandidateScore;

import java.util.List;

public interface RankingEngine {

    List<CandidateScore> rank(List<CandidateScore> scores, int topK);

}