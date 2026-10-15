package com.resolvedd.workoutapi.constants;

public class ControllerConstants {

    private ControllerConstants() {}

    public static final String BASE_API_URL = "/api/workout/";
    public static final String EXERCISE_CONTROLLER_REQUEST_MAPPING = BASE_API_URL + "exercises";
    public static final String MESOCYCLE_CONTROLLER_REQUEST_MAPPING = BASE_API_URL + "mesocycles";
    public static final String WORKOUT_CONTROLLER_REQUEST_MAPPING = BASE_API_URL + "workouts";
    public static final String WORKOUT_TEMPLATE_CONTROLLER_REQUEST_MAPPING = BASE_API_URL + "workoutTemplates";
    public static final String USER_INFO_CONTROLLER_REQUEST_MAPPING = BASE_API_URL + "profile";
}
