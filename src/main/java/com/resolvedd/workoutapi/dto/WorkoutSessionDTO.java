package com.resolvedd.workoutapi.dto;

import com.resolvedd.workoutapi.model.Workout;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class WorkoutSessionDTO {

    private Long id;
    private LocalDate date;
    private Workout workout;
    private List<SessionExerciseDTO> exercises;
}
