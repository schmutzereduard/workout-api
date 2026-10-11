package com.resolvedd.workoutapi.repository;

import com.resolvedd.workoutapi.model.Mesocycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MesocycleRepository extends JpaRepository<Mesocycle, Long> {

    List<Mesocycle> findAllByUserId(Long userId);
}
