package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.model.Workout;
import com.resolvedd.workoutapi.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public List<Workout> findAll() {
        return workoutRepository.findAll();
    }

    public Workout save(Workout workout) {
        return workoutRepository.save(workout);
    }

    public void deleteAllById(List<Long> ids) {
        workoutRepository.deleteAllById(ids);
    }

    public void deleteById(Long id) {
        workoutRepository.deleteById(id);
    }
}
