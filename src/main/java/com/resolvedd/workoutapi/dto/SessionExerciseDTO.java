package com.resolvedd.workoutapi.dto;

import com.resolvedd.workoutapi.model.Exercise;
import lombok.Data;

import java.util.List;

@Data
public class SessionExerciseDTO {

    private Long id;
    private Exercise exercise;
    private List<WorkingSetDTO> workingSets;
}
