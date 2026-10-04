package com.resolvedd.workoutapi.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.resolvedd.workoutapi.constants.ValidationConstants.*;

@Data
public class UserInfoDTO {

    @NotBlank(message = FIRST_NAME_VALIDATION)
    private String firstName;

    @NotBlank(message = LAST_NAME_VALIDATION)
    private String lastName;

    @NotBlank(message = GENDER_VALIDATION)
    @Pattern(regexp = "^[MF]$", message = GENDER_VALIDATION2)
    private String gender;

    @NotNull(message = DATE_OF_BIRTH_VALIDATION)
    private LocalDate dateOfBirth;

    @NotNull(message = HEIGHT_VALIDATION)
    @Positive(message = HEIGHT_VALIDATION2)
    private int heightInCm;

    @NotNull(message = HEIGHT_VALIDATION)
    @Positive(message = HEIGHT_VALIDATION2)
    private BigDecimal weightInKg;
}
