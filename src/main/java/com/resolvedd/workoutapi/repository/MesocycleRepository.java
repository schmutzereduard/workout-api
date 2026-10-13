package com.resolvedd.workoutapi.repository;

import com.resolvedd.workoutapi.model.Mesocycle;
import com.resolvedd.workoutapi.model.MesocycleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MesocycleRepository extends JpaRepository<Mesocycle, Long> {

    List<Mesocycle> findAllByUserId(Long userId);
    List<Mesocycle> findAllByUserIdAndStatus(Long userId, MesocycleStatus status);
}
