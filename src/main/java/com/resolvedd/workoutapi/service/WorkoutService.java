package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.dto.WorkoutDTO;
import com.resolvedd.workoutapi.mapper.WorkoutMapper;
import com.resolvedd.workoutapi.model.Workout;
import com.resolvedd.workoutapi.model.WorkoutExercise;
import com.resolvedd.workoutapi.repository.WorkoutExerciseRepository;
import com.resolvedd.workoutapi.repository.WorkoutRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final WorkoutExerciseRepository workoutExerciseRepository;
    private final WorkoutMapper workoutMapper;

    public List<WorkoutDTO> findAll() {
        return workoutRepository.findAll()
                .stream()
                .map(workoutMapper::toDTO)
                .toList();
    }

    public List<WorkoutDTO> findAllByUserId(Long userId) {
        return workoutRepository.findAllByUserId(userId)
                .stream()
                .map(workoutMapper::toDTO)
                .toList();
    }

    public WorkoutDTO save(WorkoutDTO workoutDTO) {
        Workout workout = workoutRepository.save(workoutMapper.toEntity(workoutDTO));
        return workoutMapper.toDTO(workout);
    }

    public void deleteAllById(List<Long> ids) {
        for (Long id : ids) {
            deleteById(id);
        }
    }

    @Transactional
    public void deleteById(Long id) {

        List<WorkoutExercise> workoutExercises = workoutExerciseRepository.findAllByWorkoutId(id);
        workoutExerciseRepository.deleteAll(workoutExercises);

        workoutRepository.deleteById(id);
    }
}
