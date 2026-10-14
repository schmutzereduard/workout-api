package com.resolvedd.workoutapi.constants;

public class ExceptionConstants {

    private ExceptionConstants() {}

    public static final String USER_INFO_NOT_FOUND_EXCEPTION_MESSAGE_FORMAT = "Unable to find user info for userId: %d";
    public static final String MESOCYCLE_NOT_FOUND_EXCEPTION_MESSAGE_FORMAT = "Unable to find mesocycle with id: %d";
    public static final String WORKOUT_TEMPLATE_NOT_FOUND_EXCEPTION_MESSAGE_FORMAT = "Unable to find workout template with id: %d";
    public static final String EXERCISE_NOT_FOUND_EXCEPTION_MESSAGE_FORMAT = "Unable to find exercise with id: %d";
    public static final String UNKNOWN_GENDER_EXCEPTION_MESSAGE_FORMAT = "Unable to identify gender from: %s";
}
