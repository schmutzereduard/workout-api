package com.resolvedd.workoutapi.repository;

import com.resolvedd.workoutapi.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findAllByUserId(Long userId);
}
