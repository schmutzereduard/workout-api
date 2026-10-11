package com.resolvedd.workoutapi.exception;

public class UserInfoNotFoundException extends RuntimeException {
    public UserInfoNotFoundException(String message) {
        super(message);
    }
}
