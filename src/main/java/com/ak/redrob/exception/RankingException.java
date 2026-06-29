package com.ak.redrob.exception;

/**
 * Custom checked exception thrown when errors occur during candidate loading, scoring, or ranking.
 */
public class RankingException extends Exception {

    public RankingException(String message) {
        super(message);
    }

    public RankingException(String message, Throwable cause) {
        super(message, cause);
    }
}
