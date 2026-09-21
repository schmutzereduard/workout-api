package com.resolvedd.workoutapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import static com.resolvedd.workoutapi.constants.ValidationConstants.EXERCISE_NAME_VALIDATION;

@Data
public class ExerciseDTO {

    private Long id;

    @NotBlank(message = EXERCISE_NAME_VALIDATION)
    private String name;

    private String cues;
}
