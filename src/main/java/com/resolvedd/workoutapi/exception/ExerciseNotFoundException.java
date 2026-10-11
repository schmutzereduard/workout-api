package com.resolvedd.workoutapi.exception;

public class ExerciseNotFoundException extends RuntimeException{

    public ExerciseNotFoundException(String message) {
        super(message);
    }
}
