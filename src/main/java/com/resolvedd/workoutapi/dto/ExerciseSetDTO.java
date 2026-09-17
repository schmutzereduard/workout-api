package com.resolvedd.workoutapi.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExerciseSetDTO {

    private Long id;
    private int setNumber;
    private BigDecimal weight;
    private int targetRepetitions;
    private int actualRepetitions;
    private boolean isCompleted;
}
