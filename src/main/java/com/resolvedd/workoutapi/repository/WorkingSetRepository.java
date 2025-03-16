package com.resolvedd.workoutapi.repository;

import com.resolvedd.workoutapi.model.WorkingSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkingSetRepository extends JpaRepository<WorkingSet, Long> {

    List<WorkingSet> findAllByExerciseId(Long id);
}
