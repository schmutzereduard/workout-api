package com.resolvedd.workoutapi.repository;

import com.resolvedd.workoutapi.model.Muscle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuscleRepository extends JpaRepository<Muscle, Long> {
}
