package com.resolvedd.workoutapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ExerciseDTO(

        SyncMetadata metadata,

        @NotBlank(message = "Exercise name cannot be empty!")
        @Size(min = 1, max = 255, message = "Exercise name cannot exceed 255 characters!")
        String name,

        @Size(max = 255, message = "Exercise cues cannot exceed 255 characters")
        String cues
) {}