package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.dto.WorkoutDTO;
import com.resolvedd.workoutapi.mapper.WorkoutMapper;
import com.resolvedd.workoutapi.model.Workout;
import com.resolvedd.workoutapi.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final WorkoutMapper workoutMapper;

    public List<WorkoutDTO> findAllByUserId(Long userId) {
        return workoutRepository.findAllByUserId(userId)
                .stream()
                .map(workoutMapper::toDTO)
                .toList();
    }

    @Transactional
    public WorkoutDTO save(Long userId, WorkoutDTO workoutDTO) {
        Workout workout = workoutMapper.toEntity(workoutDTO);
        workout.setUserId(userId);
        return workoutMapper.toDTO(workoutRepository.save(workout));
    }

    @Transactional
    public void deleteAllById(List<Long> ids) {
        workoutRepository.deleteAllById(ids);
    }

    @Transactional
    public void deleteById(Long id) {
        workoutRepository.deleteById(id);
    }
}
