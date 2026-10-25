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

        @NotBlank(message = "Workout name is required!")
        @Size(min = 1, max = 50, message = "Workout name must be between 1 and 50 characters!")
        String name,

        @Size(max = 255, message = "Workout notes must be 255 characters max!")
        String notes,

        Boolean isDeload,

        @NotNull(message = "Workout completion date is required!")
        LocalDateTime completedAt,

        @Valid
        List<WorkoutExerciseDTO> exercises
) {
        public WorkoutDTO {
                if (isDeload == null) {
                        isDeload = false;
                }
        }
}