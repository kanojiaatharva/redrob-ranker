package com.ak.redrob.feature;

import com.ak.redrob.model.Candidate;
import com.ak.redrob.model.JobDescription;

public interface FeatureExtractor {

    double extract(Candidate candidate,
                   JobDescription jobDescription);

}
