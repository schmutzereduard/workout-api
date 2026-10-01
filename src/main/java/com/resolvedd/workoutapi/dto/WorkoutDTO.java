package com.resolvedd.workoutapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import static com.resolvedd.workoutapi.constants.ValidationConstants.*;

@Data
public class WorkoutDTO {

    private Long id;

    @NotBlank(message = WORKOUT_NAME_VALIDATION)
    private String name;

    @NotNull(message = WORKOUT_DATE_VALIDATION)
    private LocalDateTime date;

    @Size(max = 255, message = WORKOUT_NOTES_VALIDATION)
    private String notes;

    private List<WorkoutExerciseDTO> exercises;
}
