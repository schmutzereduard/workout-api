package com.resolvedd.workoutapi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record WorkoutTemplateDTO (

        SyncMetadata metadata,

        @NotBlank(message = "Workout template name cannot be empty!")
        @Size(min = 1, max = 255, message = "Workout template name must be between 1 and 255 characters!")
        String name,

        @Size(max = 255, message = "WorkoutTemplate notes cannot be greater than 255 characters!")
        String notes,

        @Valid
        List<TemplateExerciseDTO> templateExercises
){}