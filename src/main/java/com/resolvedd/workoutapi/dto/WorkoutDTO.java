package com.resolvedd.workoutapi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

public record WorkoutDTO (

        SyncMetadata metadata,

        Long workoutTemplateId,

        @NotBlank(message = "Workout name cannot be empty!")
        String name,

        @Size(max = 255, message = "Workout notes cannot be greater than 255 characters!")
        String notes,

        @NotNull(message = "Workout completion date is required!")
        LocalDateTime completedAt,

        @Valid
        List<WorkoutExerciseDTO> exercises
) {}