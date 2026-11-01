package com.resolvedd.workoutapi.model.enums;

import lombok.Getter;

@Getter
public enum WeightUnit {

    LBS("lbs"),
    KG("kg");

    private final String value;

    WeightUnit(String value) {
        this.value = value;
    }
}
