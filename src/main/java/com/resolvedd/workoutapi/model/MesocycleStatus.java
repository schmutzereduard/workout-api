package com.resolvedd.workoutapi.model;

public enum MesocycleStatus {

    INACTIVE("I"),
    ACTIVE("A"),
    COMPLETED("C");

    private final String value;
    MesocycleStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
