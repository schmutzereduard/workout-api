package com.resolvedd.workoutapi.model.enums;

import lombok.Getter;

@Getter
public enum UserGender {

    MALE("M"),
    FEMALE("F");

    private final String value;

    UserGender(String value) {
        this.value = value;
    }
}
