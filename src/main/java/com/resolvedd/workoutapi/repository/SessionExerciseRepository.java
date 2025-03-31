package com.resolvedd.workoutapi.repository;

import com.resolvedd.workoutapi.model.SessionExercise;
import com.resolvedd.workoutapi.model.WorkoutSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionExerciseRepository extends JpaRepository<SessionExercise, Long> {

    List<SessionExercise> findAllByWorkoutSession(WorkoutSession workoutSession);
}