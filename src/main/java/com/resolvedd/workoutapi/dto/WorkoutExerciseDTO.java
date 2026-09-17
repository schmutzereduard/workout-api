package com.resolvedd.workoutapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class WorkoutExerciseDTO {

    private Long id;
    private ExerciseDTO exercise;
    private int order;
    private String notes;
    private List<ExerciseSetDTO> sets;
}
