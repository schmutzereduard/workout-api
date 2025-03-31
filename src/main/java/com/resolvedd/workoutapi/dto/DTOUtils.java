package com.resolvedd.workoutapi.dto;

import com.resolvedd.workoutapi.model.SessionExercise;
import com.resolvedd.workoutapi.model.WorkingSet;
import com.resolvedd.workoutapi.model.WorkoutSession;

import java.util.stream.Collectors;

public class DTOUtils {

    private DTOUtils() {}

    public static WorkoutSessionDTO convertToDTO(WorkoutSession workoutSession) {

        WorkoutSessionDTO dto = new WorkoutSessionDTO();
        dto.setId(workoutSession.getId());
        dto.setDate(workoutSession.getDate());
        dto.setWorkout(workoutSession.getWorkout());
        dto.setExercises(workoutSession.getSessionExercises().stream().map(DTOUtils::convertToDTO).collect(Collectors.toList()));

        return dto;
    }

    public static SessionExerciseDTO convertToDTO(SessionExercise sessionExercise) {

        SessionExerciseDTO dto = new SessionExerciseDTO();
        dto.setId(sessionExercise.getId());
        dto.setExercise(sessionExercise.getWorkoutExercise().getExercise());
        dto.setWorkingSets(sessionExercise.getWorkingSets().stream().map(DTOUtils::convertToDTO).collect(Collectors.toList()));

        return dto;
    }

    public static WorkingSetDTO convertToDTO(WorkingSet workingSet) {

        WorkingSetDTO dto = new WorkingSetDTO();
        dto.setId(workingSet.getId());
        dto.setWeight(workingSet.getWeight());
        dto.setGoal(workingSet.getGoal());
        dto.setActual(workingSet.getActual());

        return dto;
    }
}
