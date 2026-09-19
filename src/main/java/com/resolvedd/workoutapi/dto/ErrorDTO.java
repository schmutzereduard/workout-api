package com.resolvedd.workoutapi.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@RequiredArgsConstructor
public class ErrorDTO {

    private final int status;
    private final String error;
    private final String message;
    private final Instant timestamp;
}