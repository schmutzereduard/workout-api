package com.resolvedd.workoutapi.model;

import lombok.Getter;

@Getter
public enum MesocycleStatus {

    INACTIVE("I"),
    ACTIVE("A"),
    COMPLETED("C");

    private final String value;
    MesocycleStatus(String value) {
        this.value = value;
    }
}
