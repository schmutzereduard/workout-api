package com.resolvedd.workoutapi.repository;

import com.resolvedd.workoutapi.model.WorkoutTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutTemplateRepository extends JpaRepository<WorkoutTemplate, Long> {

    List<WorkoutTemplate> findAllByMesocycleId(Long mesocycleId);
}
