package com.resolvedd.workoutapi.repository;

import com.resolvedd.workoutapi.model.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SetRepository extends JpaRepository<Set, Long> {

    List<Set> findAllByExerciseId(Long id);
}
