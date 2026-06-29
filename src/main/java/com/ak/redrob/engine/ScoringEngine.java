package com.ak.redrob.engine;

import com.ak.redrob.model.Candidate;
import com.ak.redrob.model.CandidateScore;
import com.ak.redrob.model.JobDescription;

public interface ScoringEngine {

    CandidateScore score(Candidate candidate, JobDescription jobDescription);

}