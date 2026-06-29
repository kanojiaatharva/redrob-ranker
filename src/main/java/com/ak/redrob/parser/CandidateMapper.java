package com.ak.redrob.parser;

import com.ak.redrob.model.Candidate;
import com.fasterxml.jackson.databind.JsonNode;

public interface CandidateMapper {

    Candidate map(JsonNode node);

}