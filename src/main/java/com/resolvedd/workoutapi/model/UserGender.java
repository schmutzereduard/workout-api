package com.resolvedd.workoutapi.model;

public enum UserGender {

    MALE("M"),
    FEMALE("F");

    private final String value;
    UserGender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
