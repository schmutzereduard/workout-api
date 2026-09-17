package com.resolvedd.workoutapi.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class WorkoutDTO {

    private Long id;
    private String name;
    private LocalDateTime date;
    private String notes;
    private List<WorkoutExerciseDTO> exercises;
}
