package com.resolvedd.workoutapi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record WorkoutTemplateDTO (

        SyncMetadata metadata,

        @NotBlank(message = "Workout template name is required!")
        @Size(min = 1, max = 255, message = "Workout template name must be between 1 and 255 characters!")
        String name,

        @Size(max = 255, message = "Workout template notes must be 255 characters max!")
        String notes,

        Boolean isDeload,

        @Valid
        List<TemplateExerciseDTO> templateExercises
){
        public WorkoutTemplateDTO {
                if (isDeload == null) {
                        isDeload = false;
                }
        }
}