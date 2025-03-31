package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.model.Workout;
import com.resolvedd.workoutapi.model.WorkoutExercise;
import com.resolvedd.workoutapi.repository.WorkoutExerciseRepository;
import com.resolvedd.workoutapi.repository.WorkoutRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final WorkoutExerciseRepository workoutExerciseRepository;

    public List<Workout> findAll() {
        return workoutRepository.findAll();
    }

    public Workout save(Workout workout) {
        return workoutRepository.save(workout);
    }

    @Transactional
    public void deleteAllById(List<Long> ids) {
        for (Long id : ids) {
            deleteById(id);
        }
    }

    @Transactional
    public void deleteById(Long id) {
        //  Delete entries in the join table
        List<WorkoutExercise> workoutExercises = workoutExerciseRepository.findAllByWorkoutId(id);
        workoutExerciseRepository.deleteAll(workoutExercises);

        //  Now delete the workout
        workoutRepository.deleteById(id);
    }
}
