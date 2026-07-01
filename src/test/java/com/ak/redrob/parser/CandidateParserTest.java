package com.ak.redrob.parser;

import com.ak.redrob.model.Candidate;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CandidateParserTest {

    @Test
    void shouldParseValidJsonlFile() throws Exception {

        Path jsonl = Files.createTempFile("candidate", ".jsonl");

        Files.writeString(
                jsonl,
                "{\"candidate_id\":\"C001\",\"profile\":{\"anonymized_name\":\"John\",\"headline\":\"AI Engineer\",\"summary\":\"LLM Engineer\",\"location\":\"Pune\",\"country\":\"India\",\"years_of_experience\":6,\"current_title\":\"Senior AI Engineer\",\"current_company\":\"OpenAI\",\"current_company_size\":\"1000+\",\"current_industry\":\"AI\"},\"career_history\":[],\"education\":[],\"skills\":[],\"certifications\":[],\"languages\":[],\"redrob_signals\":{\"profile_completeness_score\":95}}\n"
        );

        CandidateParser parser = new CandidateParser();

        try (Stream<Candidate> stream = parser.parse(jsonl)) {

            assertEquals(1, stream.count());

        }

    }

    @Test
    void shouldSkipMalformedRecords() throws Exception {

        Path jsonl = Files.createTempFile("bad", ".jsonl");

        Files.writeString(jsonl,
                """
                {invalid json}
                """);

        CandidateParser parser = new CandidateParser();

        try (Stream<Candidate> stream = parser.parse(jsonl)) {

            assertEquals(0, stream.count());

        }

    }

    @Test
    void shouldThrowForMissingFile() {

        CandidateParser parser = new CandidateParser();

        assertThrows(
                CandidateParserException.class,
                () -> parser.parse(Path.of("missing.jsonl"))
        );

    }

}