package com.resolvedd.workoutapi.constants;

public class ExceptionConstants {

    private ExceptionConstants() {}

    public static final String USER_INFO_NOT_FOUND_EXCEPTION_MESSAGE_FORMAT = "Unable to find user info for userId: %d";
    public static final String MESOCYCLE_NOT_FOUND_EXCEPTION_MESSAGE_FORMAT = "Unable to find mesocycle with id: %d";
    public static final String WORKOUT_TEMPLATE_NOT_FOUND_EXCEPTION_MESSAGE_FORMAT = "Unable to find workout template with id: %d";
    public static final String EXERCISE_NOT_FOUND_EXCEPTION_MESSAGE_FORMAT = "Unable to find exercise with id: %d";
    public static final String UNKNOWN_MESOCYCLE_STATUS_EXCEPTION_MESSAGE_FORMAT = "Unable to identify mesocycle status from: %s";
    public static final String UNKNOWN_GENDER_EXCEPTION_MESSAGE_FORMAT = "Unable to identify gender from: %s";
    public static final String MESOCYCLE_ALREADY_IN_PROGRESS_EXCEPTION_MESSAGE = "There can only be one Active mesocycle at a time";
    public static final String MESOCYCLE_ALREADY_ENDED_EXCEPTION_FORMAT = "Mesocycle ended on %s";
    public static final String MESOCYCLE_NOT_STARTED_EXCEPTION_MESSAGE = "Mesocycle hasn't started yet";
    public static final String MISSING_ATTRIBUTE_EXCEPTION_MESSAGE_FORMAT = "Missing %s attribute: %s";
}
