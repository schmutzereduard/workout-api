package com.resolvedd.workoutapi.repository;

import com.resolvedd.workoutapi.model.TrainingDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingDayRepository extends JpaRepository<TrainingDay, Long> {
}
