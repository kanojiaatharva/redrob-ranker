package com.ak.redrob.exception;

public class RankingException extends RuntimeException {

    public RankingException(String message) {
        super(message);
    }

    public RankingException(String message, Throwable cause) {
        super(message, cause);
    }
}