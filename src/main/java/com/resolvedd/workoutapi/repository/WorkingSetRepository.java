package com.resolvedd.workoutapi.repository;

import com.resolvedd.workoutapi.model.WorkingSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingSetRepository extends JpaRepository<WorkingSet, Long> {

}
