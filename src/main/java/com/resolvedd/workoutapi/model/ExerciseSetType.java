package com.resolvedd.workoutapi.model;

import lombok.Getter;

@Getter
public enum ExerciseSetType {

    WARMUP("Warmup"),
    WORKING("Working");

    private final String value;

    ExerciseSetType(String value) {
        this.value = value;
    }
}
