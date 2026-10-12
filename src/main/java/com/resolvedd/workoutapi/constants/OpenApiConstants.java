package com.resolvedd.workoutapi.constants;

public class OpenApiConstants {

    private OpenApiConstants() {}

    public static final String RESPONSE_CODE_OK = "200";
    public static final String RESPONSE_CODE_CREATED = "201";
    public static final String RESPONSE_CODE_NO_CONTENT = "204";
    public static final String RESPONSE_CODE_UNAUTHORIZED = "401";
    public static final String JSON_MEDIA_TYPE = "application/json";
    public static final String RESPONSE_CODE_UNAUTHORIZED_DESCRIPTION = "User is not authorized";

    public static final String INFO_TITLE = "Workout Management API";
    public static final String INFO_VERSION = "1.0";
    public static final String INFO_DESCRIPTION = "Workout Management API";
    public static final String SECURITY_SCHEME_NAME = "bearerAuth";
    public static final String SECURITY_SCHEME = "bearer";
    public static final String SECURITY_SCHEME_FORMAT = "JWT";
    public static final String SECURITY_SCHEME_DESCRIPTION = "Enter the JWT bearer token";

    public static final String EXERCISE_CONTROLLER_TAG_NAME = "Exercises Management";
    public static final String EXERCISE_CONTROLLER_TAG_DESCRIPTION = "Endpoints for managing user's exercises";

    public static final String EXERCISE_CONTROLLER_GET_EXERCISES_OPERATION_SUMMARY = "Get all user's exercises";
    public static final String EXERCISE_CONTROLLER_GET_EXERCISES_OPERATION_DESCRIPTION = "Retrieves a list of all exercises belonging to the authenticated user.";
    public static final String EXERCISE_CONTROLLER_GET_EXERCISES_OK_DESCRIPTION = "Successfully retrieved exercises list";

    public static final String EXERCISE_CONTROLLER_PUT_EXERCISE_OPERATION_SUMMARY = "Update an exercise";
    public static final String EXERCISE_CONTROLLER_PUT_EXERCISE_OPERATION_DESCRIPTION = "Updates an existing exercise for the authenticated user.";
    public static final String EXERCISE_CONTROLLER_PUT_EXERCISE_OK_DESCRIPTION = "Exercise updated successfully";

    public static final String EXERCISE_CONTROLLER_POST_EXERCISE_OPERATION_SUMMARY = "Create a new exercise";
    public static final String EXERCISE_CONTROLLER_POST_EXERCISE_OPERATION_DESCRIPTION = "Registers a new exercise for the authenticated user.";
    public static final String EXERCISE_CONTROLLER_POST_EXERCISE_OK_DESCRIPTION = "Exercise created successfully";

    public static final String EXERCISE_CONTROLLER_DELETE_EXERCISES_OPERATION_SUMMARY = "Delete multiple exercises";
    public static final String EXERCISE_CONTROLLER_DELETE_EXERCISES_OPERATION_DESCRIPTION = "Deletes a batch of exercises by their IDs.";
    public static final String EXERCISE_CONTROLLER_DELETE_EXERCISES_OK_DESCRIPTION = "Exercise deleted successfully";

    public static final String EXERCISE_CONTROLLER_DELETE_EXERCISE_OPERATION_SUMMARY = "Delete an exercise by ID";
    public static final String EXERCISE_CONTROLLER_DELETE_EXERCISE_OPERATION_DESCRIPTION = "Deletes a specific exercise using its unique identifier.";
    public static final String EXERCISE_CONTROLLER_DELETE_EXERCISE_OK_DESCRIPTION = "Exercise deleted successfully";

    public static final String MESOCYCLE_CONTROLLER_TAG_NAME = "Mesocycles Management";
    public static final String MESOCYCLE_CONTROLLER_TAG_DESCRIPTION = "Endpoints for managing user's training mesocycles";

    public static final String MESOCYCLE_CONTROLLER_GET_MESOCYCLES_OPERATION_SUMMARY = "Get all user's mesocycles";
    public static final String MESOCYCLE_CONTROLLER_GET_MESOCYCLES_OPERATION_DESCRIPTION = "Retrieves a list of all training mesocycles belonging to the authenticated user.";
    public static final String MESOCYCLE_CONTROLLER_GET_MESOCYCLES_OK_DESCRIPTION = "Successfully retrieved list";

    public static final String MESOCYCLE_CONTROLLER_PUT_MESOCYCLE_OPERATION_SUMMARY = "Update a mesocycle";
    public static final String MESOCYCLE_CONTROLLER_PUT_MESOCYCLE_OPERATION_DESCRIPTION = "Updates an existing training mesocycle for the authenticated user.";
    public static final String MESOCYCLE_CONTROLLER_PUT_MESOCYCLE_OK_DESCRIPTION = "Mesocycle updated successfully";

    public static final String MESOCYCLE_CONTROLLER_POST_MESOCYCLE_OPERATION_SUMMARY = "Create a new mesocycle";
    public static final String MESOCYCLE_CONTROLLER_POST_MESOCYCLE_OPERATION_DESCRIPTION = "Registers a new training mesocycle for the authenticated user.";
    public static final String MESOCYCLE_CONTROLLER_POST_MESOCYCLE_OK_DESCRIPTION = "Mesocycle created successfully";

    public static final String MESOCYCLE_CONTROLLER_DELETE_MESOCYCLES_OPERATION_SUMMARY = "Delete multiple mesocycles";
    public static final String MESOCYCLE_CONTROLLER_DELETE_MESOCYCLES_OPERATION_DESCRIPTION = "Deletes a batch of training mesocycles by their IDs.";
    public static final String MESOCYCLE_CONTROLLER_DELETE_MESOCYCLES_OK_DESCRIPTION = "Mesocycles deleted successfully";

    public static final String MESOCYCLE_CONTROLLER_DELETE_MESOCYCLE_OPERATION_SUMMARY = "Delete a mesocycle by ID";
    public static final String MESOCYCLE_CONTROLLER_DELETE_MESOCYCLE_OPERATION_DESCRIPTION = "Deletes a specific training mesocycle using its unique identifier.";
    public static final String MESOCYCLE_CONTROLLER_DELETE_MESOCYCLE_OK_DESCRIPTION = "Mesocycle deleted successfully";

    public static final String TEMPLATE_EXERCISE_CONTROLLER_TAG_NAME = "Template Exercises Management";
    public static final String TEMPLATE_EXERCISE_CONTROLLER_TAG_DESCRIPTION = "Endpoints for managing template exercises";

    public static final String TEMPLATE_EXERCISE_CONTROLLER_GET_TEMPLATE_EXERCISES_OPERATION_SUMMARY = "Get all template exercises";
    public static final String TEMPLATE_EXERCISE_CONTROLLER_GET_TEMPLATE_EXERCISES_OPERATION_DESCRIPTION = "Retrieves a list of all template exercises.";
    public static final String TEMPLATE_EXERCISE_CONTROLLER_GET_TEMPLATE_EXERCISES_OK_DESCRIPTION = "Successfully retrieved list";

    public static final String TEMPLATE_EXERCISE_CONTROLLER_PUT_TEMPLATE_EXERCISE_OPERATION_SUMMARY = "Update a template exercise";
    public static final String TEMPLATE_EXERCISE_CONTROLLER_PUT_TEMPLATE_EXERCISE_OPERATION_DESCRIPTION = "Updates an existing template exercise.";
    public static final String TEMPLATE_EXERCISE_CONTROLLER_PUT_TEMPLATE_EXERCISE_OK_DESCRIPTION = "Template exercise updated successfully";

    public static final String TEMPLATE_EXERCISE_CONTROLLER_POST_TEMPLATE_EXERCISE_OPERATION_SUMMARY = "Create a new template exercise";
    public static final String TEMPLATE_EXERCISE_CONTROLLER_POST_TEMPLATE_EXERCISE_OPERATION_DESCRIPTION = "Registers a new template exercise.";
    public static final String TEMPLATE_EXERCISE_CONTROLLER_POST_TEMPLATE_EXERCISE_OK_DESCRIPTION = "Template exercise created successfully";

    public static final String TEMPLATE_EXERCISE_CONTROLLER_DELETE_TEMPLATE_EXERCISES_OPERATION_SUMMARY = "Delete multiple template exercises";
    public static final String TEMPLATE_EXERCISE_CONTROLLER_DELETE_TEMPLATE_EXERCISES_OPERATION_DESCRIPTION = "Deletes a batch of template exercises by their IDs.";
    public static final String TEMPLATE_EXERCISE_CONTROLLER_DELETE_TEMPLATE_EXERCISES_OK_DESCRIPTION = "Template exercises deleted successfully";

    public static final String TEMPLATE_EXERCISE_CONTROLLER_DELETE_TEMPLATE_EXERCISE_OPERATION_SUMMARY = "Delete a template exercise by ID";
    public static final String TEMPLATE_EXERCISE_CONTROLLER_DELETE_TEMPLATE_EXERCISE_OPERATION_DESCRIPTION = "Deletes a specific template exercise using its unique identifier.";
    public static final String TEMPLATE_EXERCISE_CONTROLLER_DELETE_TEMPLATE_EXERCISE_OK_DESCRIPTION = "Template exercise deleted successfully";

    public static final String WORKOUT_CONTROLLER_TAG_NAME = "Workouts Management";
    public static final String WORKOUT_CONTROLLER_TAG_DESCRIPTION = "Endpoints for managing user's workouts";

    public static final String WORKOUT_CONTROLLER_GET_WORKOUTS_OPERATION_SUMMARY = "Get all user's workouts";
    public static final String WORKOUT_CONTROLLER_GET_WORKOUTS_OPERATION_DESCRIPTION = "Retrieves a list of all workouts belonging to the authenticated user.";
    public static final String WORKOUT_CONTROLLER_GET_WORKOUTS_OK_DESCRIPTION = "Successfully retrieved list";

    public static final String WORKOUT_CONTROLLER_PUT_WORKOUT_OPERATION_SUMMARY = "Create a new workout";
    public static final String WORKOUT_CONTROLLER_PUT_WORKOUT_OPERATION_DESCRIPTION = "Registers a new workout for the authenticated user.";
    public static final String WORKOUT_CONTROLLER_PUT_WORKOUT_OK_DESCRIPTION = "Workout created successfully";

    public static final String WORKOUT_CONTROLLER_POST_WORKOUT_OPERATION_SUMMARY = "Update a workout";
    public static final String WORKOUT_CONTROLLER_POST_WORKOUT_OPERATION_DESCRIPTION = "Updates an existing workout for the authenticated user.";
    public static final String WORKOUT_CONTROLLER_POST_WORKOUT_OK_DESCRIPTION = "Workout updated successfully";

    public static final String WORKOUT_CONTROLLER_DELETE_WORKOUTS_OPERATION_SUMMARY = "Delete multiple workouts";
    public static final String WORKOUT_CONTROLLER_DELETE_WORKOUTS_OPERATION_DESCRIPTION = "Deletes a batch of workouts by their IDs.";
    public static final String WORKOUT_CONTROLLER_DELETE_WORKOUTS_OK_DESCRIPTION = "Workouts deleted successfully";

    public static final String WORKOUT_CONTROLLER_DELETE_WORKOUT_OPERATION_SUMMARY = "Delete a workout by ID";
    public static final String WORKOUT_CONTROLLER_DELETe_WORKOUT_OPERATION_DESCRIPTION = "Deletes a specific workout using its unique identifier.";
    public static final String WORKOUT_CONTROLLER_DELETE_WORKOUT_OK_DESCRIPTION = "Workout deleted successfully";

    public static final String WORKOUT_TEMPLATE_CONTROLLER_TAG_NAME = "Workout Templates Management";
    public static final String WORKOUT_TEMPLATE_CONTROLLER_TAG_DESCRIPTION = "Endpoints for managing user's workout templates";

    public static final String WORKOUT_TEMPLATE_CONTROLLER_GET_WORKOUT_TEMPLATES_OPERATION_SUMMARY = "Get all workout templates from a mesocycle";
    public static final String WORKOUT_TEMPLATE_CONTROLLER_GET_WORKOUT_TEMPLATES_OPERATION_DESCRIPTION = "Retrieves a list of all workout templates belonging to a mesocycle.";
    public static final String WORKOUT_TEMPLATE_CONTROLLER_GET_WORKOUT_TEMPLATES_OK_DESCRIPTION = "Successfully retrieved list";

    public static final String WORKOUT_TEMPLATE_CONTROLLER_PUT_WORKOUT_TEMPLATE_OPERATION_SUMMARY = "Update a workout template";
    public static final String WORKOUT_TEMPLATE_CONTROLLER_PUT_WORKOUT_TEMPLATE_OPERATION_DESCRIPTION = "Updates an existing workout template for the authenticated user.";
    public static final String WORKOUT_TEMPLATE_CONTROLLER_PUT_WORKOUT_TEMPLATE_OK_DESCRIPTION = "Workout template updated successfully";

    public static final String WORKOUT_TEMPLATE_CONTROLLER_POST_WORKOUT_TEMPLATE_OPERATION_SUMMARY = "Create a new workout template";
    public static final String WORKOUT_TEMPLATE_CONTROLLER_POST_WORKOUT_TEMPLATE_OPERATION_DESCRIPTION = "Registers a new workout template for the authenticated user.";
    public static final String WORKOUT_TEMPLATE_CONTROLLER_POST_WORKOUT_TEMPLATE_OK_DESCRIPTION = "Workout template created successfully";

    public static final String WORKOUT_TEMPLATE_CONTROLLER_DELETE_WORKOUT_TEMPLATES_OPERATION_SUMMARY = "Delete multiple workout templates";
    public static final String WORKOUT_TEMPLATE_CONTROLLER_DELETE_WORKOUT_TEMPLATES_OPERATION_DESCRIPTION = "Deletes a batch of workout templates by their IDs.";
    public static final String WORKOUT_TEMPLATE_CONTROLLER_DELETE_WORKOUT_TEMPLATES_OK_DESCRIPTION = "Workout templates deleted successfully";

    public static final String WORKOUT_TEMPLATE_CONTROLLER_DELETE_WORKOUT_TEMPLATE_OPERATION_SUMMARY = "Delete a workout template by ID";
    public static final String WORKOUT_TEMPLATE_CONTROLLER_DELETE_WORKOUT_TEMPLATE_OPERATION_DESCRIPTION = "Deletes a specific workout template using its unique identifier.";
    public static final String WORKOUT_TEMPLATE_CONTROLLER_DELETE_WORKOUT_TEMPLATE_OK_DESCRIPTION = "Workout template deleted successfully";

    public static final String EXERCISE_DTO_SCHEMA_DESCRIPTION = "Exercise transfer object";
    public static final String EXERCISE_DTO_SCHEMA_ID_DESCRIPTION = "Unique exercise identifier";
    public static final String EXERCISE_DTO_SCHEMA_NAME_DESCRIPTION = "Exercise name";
    public static final String EXERCISE_DTO_SCHEMA_NAME_EXAMPLE = "Barbell Bench Press";
    public static final String EXERCISE_DTO_SCHEMA_CUES_DESCRIPTION = "Exercise cues";
    public static final String EXERCISE_DTO_SCHEMA_CUES_EXAMPLE = "Elbows tucked";

    public static final String EXERCISE_SET_SCHEMA_DESCRIPTION = "Exercise set transfer object";
    public static final String EXERCISE_SET_SCHEMA_ID_DESCRIPTION = "Unique set identifier";
    public static final String EXERCISE_SET_SCHEMA_SET_NUMBER_DESCRIPTION = "Set number in the sequence";
    public static final String EXERCISE_SET_SCHEMA_WEIGHT_DESCRIPTION = "Weight used for the set";
    public static final String EXERCISE_SET_SCHEMA_WEIGHT_EXAMPLE = "11.5";
    public static final String EXERCISE_SET_ACTUAL_REPETITIONS_DESCRIPTION = "Actual repetitions performed";
    public static final String EXERCISE_SET_ACTUAL_REPETITIONS_EXAMPLE = "10";

    public static final String MESOCYCLE_SCHEMA_DESCRIPTION = "Mesocycle transfer object representing a training block";
    public static final String MESOCYCLE_SCHEMA_ID_DESCRIPTION = "Unique identifier of the mesocycle";
    public static final String MESOCYCLE_SCHEMA_NAME_DESCRIPTION = "Name of the mesocycle training block";
    public static final String MESOCYCLE_SCHEMA_NAME_EXAMPLE = "Hypertrophy Block 1";
    public static final String MESOCYCLE_SCHEMA_TARGET_WEEKS_DESCRIPTION = "Target duration in weeks";
    public static final String MESOCYCLE_SCHEMA_START_DATE_DESCRIPTION = "Start date of the mesocycle";
    public static final String MESOCYCLE_SCHEMA_START_DATE_EXAMPLE = "2026-06-01";
    public static final String MESOCYCLE_SCHEMA_END_DATE_DESCRIPTION = "End date of the mesocycle";
    public static final String MESOCYCLE_SCHEMA_END_DATE_EXAMPLE = "2026-06-28";
    public static final String MESOCYCLE_SCHEMA_STATUS_DESCRIPTION = "Status of the mesocycle ('I' = Inactive, 'A' = Active, 'C' = Completed)";

    public static final String TEMPLATE_EXERCISE_SCHEMA_DESCRIPTION = "Template exercise transfer object linking an exercise to a workout template with target sets and reps";
    public static final String TEMPLATE_EXERCISE_SCHEMA_ID_DESCRIPTION = "Unique identifier of the template exercise";
    public static final String TEMPLATE_EXERCISE_SCHEMA_WORKOUT_TEMPLATE_ID_DESCRIPTION = "ID of the parent workout template";
    public static final String TEMPLATE_EXERCISE_SCHEMA_EXERCISE_ID_DESCRIPTION = "ID of the associated exercise";
    public static final String TEMPLATE_EXERCISE_SCHEMA_EXERCISE_ORDER_DESCRIPTION = "Order sequence of the exercise in the template";
    public static final String TEMPLATE_EXERCISE_SCHEMA_TARGET_SETS_DESCRIPTION = "Target number of sets";
    public static final String TEMPLATE_EXERCISE_SCHEMA_TARGET_REPETITIONS_MIN_DESCRIPTION = "Minimum target repetitions per set";
    public static final String TEMPLATE_EXERCISE_SCHEMA_TARGET_REPETITIONS_MIN_EXAMPLE = "8";
    public static final String TEMPLATE_EXERCISE_SCHEMA_TARGET_REPETITIONS_MAX_DESCRIPTION = "Maximum target repetitions per set";
    public static final String TEMPLATE_EXERCISE_SCHEMA_TARGET_REPETITIONS_MAX_EXAMPLE = "12";

    public static final String USER_INFO_SCHEMA_DESCRIPTION = "User information transfer object containing personal and physical details";
    public static final String USER_INFO_SCHEMA_FIRST_NAME_DESCRIPTION = "First name of the user";
    public static final String USER_INFO_SCHEMA_FIRST_NAME_EXAMPLE = "John";
    public static final String USER_INFO_SCHEMA_LAST_NAME_DESCRIPTION = "Last name of the user";
    public static final String USER_INFO_SCHEMA_LAST_NAME_EXAMPLE = "Doe";
    public static final String USER_INFO_SCHEMA_GENDER_DESCRIPTION = "Gender of the user ('M' = Male, 'F' = Female)";
    public static final String USER_INFO_SCHEMA_DATE_OF_BIRTH_DESCRIPTION = "Date of birth of the user";
    public static final String USER_INFO_SCHEMA_DATE_OF_BIRTH_EXAMPLE = "1995-05-15";
    public static final String USER_INFO_SCHEMA_HEIGHT_IN_CM_DESCRIPTION = "Height of the user in centimeters";
    public static final String USER_INFO_SCHEMA_HEIGHT_IN_CM_EXAMPLE = "180";
    public static final String USER_INFO_SCHEMA_WEIGHT_IN_KG_DESCRIPTION = "Weight of the user in kilograms";
    public static final String USER_INFO_SCHEMA_WEIGHT_IN_KG_EXAMPLE = "75.5";

    public static final String WORKOUT_SCHEMA_DESCRIPTION = "Workout transfer object representing a completed or logged training session";
    public static final String WORKOUT_SCHEMA_ID_DESCRIPTION = "Unique identifier of the workout";
    public static final String WORKOUT_SCHEMA_NAME_DESCRIPTION = "Name of the workout session";
    public static final String WORKOUT_SCHEMA_NAME_EXAMPLE = "Upper Body Strength";
    public static final String WORKOUT_SCHEMA_DATE_DESCRIPTION = "Date and time when the workout took place";
    public static final String WORKOUT_SCHEMA_DATE_EXAMPLE = "2026-06-15T10:30:00";
    public static final String WORKOUT_SCHEMA_NOTES_DESCRIPTION = "Optional notes or comments about the workout session";
    public static final String WORKOUT_SCHEMA_NOTES_EXAMPLE = "Felt strong, hit a PR on bench press.";
    public static final String WORKOUT_SCHEMA_EXERCISES_DESCRIPTION = "List of exercises performed during this workout session";

    public static final String WORKOUT_EXERCISE_SCHEMA_DESCRIPTION = "Workout exercise transfer object linking an exercise, its sequence, notes, and performed sets to a workout session";
    public static final String WORKOUT_EXERCISE_SCHEMA_ID_DESCRIPTION = "Unique identifier of the workout exercise record";
    public static final String WORKOUT_EXERCISE_SCHEMA_EXERCISE_DESCRIPTION = "Details of the underlying exercise being performed";
    public static final String WORKOUT_EXERCISE_SCHEMA_ORDER_DESCRIPTION = "Order sequence of this exercise within the workout";
    public static final String WORKOUT_EXERCISE_SCHEMA_NOTES_DESCRIPTION = "Optional notes specific to this exercise instance";
    public static final String WORKOUT_EXERCISE_SCHEMA_NOTES_EXAMPLE = "Felt great, maintained strict form.";
    public static final String WORKOUT_EXERCISE_SCHEMA_SETS_DESCRIPTION = "List of sets completed for this exercise";

    public static final String WORKOUT_TEMPLATE_SCHEMA_DESCRIPTION = "Workout template transfer object representing a planned workout routine within a mesocycle";
    public static final String WORKOUT_TEMPLATE_SCHEMA_ID_DESCRIPTION = "Unique identifier of the workout template";
    public static final String WORKOUT_TEMPLATE_SCHEMA_MESOCYCLE_ID_DESCRIPTION = "ID of the parent mesocycle training block";
    public static final String WORKOUT_TEMPLATE_SCHEMA_NAME_DESCRIPTION = "Name of the workout template";
    public static final String WORKOUT_TEMPLATE_SCHEMA_NAME_EXAMPLE = "Leg Day A";
    public static final String WORKOUT_TEMPLATE_SCHEMA_DAY_ORDER_DESCRIPTION = "Day order sequence within the mesocycle";
    public static final String WORKOUT_TEMPLATE_SCHEMA_TEMPLATE_EXERCISES_DESCRIPTION = "List of template exercises included in this routine";
}
