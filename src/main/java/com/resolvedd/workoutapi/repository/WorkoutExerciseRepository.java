package com.resolvedd.workoutapi.repository;

import com.resolvedd.workoutapi.model.WorkoutExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise, Long> {

    List<WorkoutExercise> findAllByWorkoutId(Long workoutId);
}
