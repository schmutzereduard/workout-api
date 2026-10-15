package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.dto.WorkoutTemplateDTO;
import com.resolvedd.workoutapi.mapper.WorkoutTemplateMapper;
import com.resolvedd.workoutapi.repository.WorkoutTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutTemplateService {

    private final WorkoutTemplateRepository workoutTemplateRepository;
    private final WorkoutTemplateMapper workoutTemplateMapper;

    public List<WorkoutTemplateDTO> findAllWorkoutTemplates(Long userId) {
        return workoutTemplateRepository.findAllByUserId(userId).stream()
                .map(workoutTemplateMapper::toDTO)
                .toList();
    }

    @Transactional
    public WorkoutTemplateDTO save(WorkoutTemplateDTO workoutTemplateDTO) {
        return workoutTemplateMapper.toDTO(workoutTemplateRepository.save(workoutTemplateMapper.toEntity(workoutTemplateDTO)));
    }

    @Transactional
    public void deleteAllById(List<Long> ids) {
        ids.forEach(this::deleteById);
    }

    @Transactional
    public void deleteById(Long id) {
        workoutTemplateRepository.findById(id).ifPresent(workoutTemplate -> {
            workoutTemplate.setDeletedAt(LocalDateTime.now());
            workoutTemplateRepository.save(workoutTemplate);
        });
    }
}
