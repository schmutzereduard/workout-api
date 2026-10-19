package com.resolvedd.workoutapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record ExerciseDTO(

        SyncMetadata metadata,

        @NotBlank(message = "Exercise name is required!")
        @Size(min = 1, max = 255, message = "Exercise name must be 255 characters max!")
        String name,

        @Size(max = 255, message = "Exercise notes must be 255 characters max!")
        String notes,

        @Size(min = 1, message = "Exercise must have at least 1 muscle group assigned!  ")
        List<String> muscleGroups
) {}