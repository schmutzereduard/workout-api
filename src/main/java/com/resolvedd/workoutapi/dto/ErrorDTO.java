package com.resolvedd.workoutapi.dto;

import java.time.Instant;

public record ErrorDTO(
        int status,
        String error,
        String message,
        Instant timestamp
) {}