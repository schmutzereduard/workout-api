package com.resolvedd.workoutapi.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WorkingSetDTO {

    private Long id;
    private BigDecimal weight;
    private int goal;
    private int actual;
}
