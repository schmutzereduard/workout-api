package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.model.WorkingSet;
import com.resolvedd.workoutapi.repository.WorkingSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkingSetService {

    private final WorkingSetRepository workingSetRepository;

    public List<WorkingSet> findAllByExerciseId(Long id) {
        return workingSetRepository.findAllByExerciseId(id);
    }

    public WorkingSet save(WorkingSet workingSet) {
        return workingSetRepository.save(workingSet);
    }

    public void deleteById(Long id) {
        workingSetRepository.deleteById(id);
    }
}
