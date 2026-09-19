package com.resolvedd.workoutapi.exception;

public class AuthException extends RuntimeException {

    public AuthException(Exception cause) {
        super(cause);
    }
}
