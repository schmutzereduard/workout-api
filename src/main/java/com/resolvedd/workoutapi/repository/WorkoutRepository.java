package com.resolvedd.workoutapi.repository;

import com.resolvedd.workoutapi.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    List<Workout> findAllByUserId(Long userId);
}
