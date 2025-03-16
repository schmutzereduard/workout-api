package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.model.Exercise;
import com.resolvedd.workoutapi.model.WorkingSet;
import com.resolvedd.workoutapi.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    public Exercise save(Exercise exercise) {
        if (exercise.getWorkingSets() != null) {
            for (WorkingSet workingSet : exercise.getWorkingSets()) {
                workingSet.setExercise(exercise); // Ensuring the relationship
            }
        }
        return exerciseRepository.save(exercise);
    }

    public void deleteById(Long id) {
        exerciseRepository.deleteById(id);
    }
}
