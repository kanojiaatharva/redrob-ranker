package com.ak.redrob.parser;

/**
 * Exception thrown during candidate parsing.
 */
public class CandidateParserException extends RuntimeException {

    public CandidateParserException(String message) {
        super(message);
    }

    public CandidateParserException(String message,
                                    Throwable cause) {
        super(message, cause);
    }

}