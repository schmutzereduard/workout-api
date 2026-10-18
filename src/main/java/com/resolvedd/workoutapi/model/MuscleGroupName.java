package com.resolvedd.workoutapi.model;

import lombok.Getter;

@Getter
public enum MuscleGroupName {

    BACK("Back"),
    CHEST("Chest"),
    SHOULDERS("Shoulders"),
    BICEPS("Biceps"),
    TRICEPS("Triceps"),
    FOREARMS("Forearms"),
    CORE("Core"),
    GLUTES("Glutes"),
    QUADS("Quads"),
    HAMSTRINGS("Hamstrings"),
    CALVES("Calves");

    private final String value;
    MuscleGroupName(String value) {
        this.value = value;
    }
}
