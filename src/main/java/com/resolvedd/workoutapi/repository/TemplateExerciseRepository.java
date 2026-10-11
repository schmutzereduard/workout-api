package com.resolvedd.workoutapi.repository;

import com.resolvedd.workoutapi.model.TemplateExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateExerciseRepository extends JpaRepository<TemplateExercise, Long> {
}
