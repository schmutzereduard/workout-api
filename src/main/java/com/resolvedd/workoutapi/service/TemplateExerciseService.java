package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.dto.TemplateExerciseDTO;
import com.resolvedd.workoutapi.exception.ExerciseNotFoundException;
import com.resolvedd.workoutapi.exception.WorkoutTemplateNotFoundException;
import com.resolvedd.workoutapi.mapper.TemplateExerciseMapper;
import com.resolvedd.workoutapi.model.TemplateExercise;
import com.resolvedd.workoutapi.repository.ExerciseRepository;
import com.resolvedd.workoutapi.repository.TemplateExerciseRepository;
import com.resolvedd.workoutapi.repository.WorkoutTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.resolvedd.workoutapi.constants.ExceptionConstants.EXERCISE_NOT_FOUND_EXCEPTION_MESSAGE;
import static com.resolvedd.workoutapi.constants.ExceptionConstants.WORKOUT_TEMPLATE_NOT_FOUND_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class TemplateExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final WorkoutTemplateRepository workoutTemplateRepository;
    private final TemplateExerciseRepository templateExerciseRepository;
    private final TemplateExerciseMapper templateExerciseMapper;

    public List<TemplateExerciseDTO> findAll() {
        return templateExerciseRepository.findAll().stream()
                .map(templateExerciseMapper::toDTO)
                .toList();
    }

    @Transactional
    public TemplateExerciseDTO save(TemplateExerciseDTO templateExerciseDTO) {
        TemplateExercise templateExercise = templateExerciseMapper.toEntity(templateExerciseDTO);
        Long exerciseId = templateExerciseDTO.getExerciseId();
        Long workoutTemplateId = templateExerciseDTO.getWorkoutTemplateId();
        templateExercise.setWorkoutTemplate(workoutTemplateRepository.findById(workoutTemplateId).orElseThrow(() -> new WorkoutTemplateNotFoundException(String.format(WORKOUT_TEMPLATE_NOT_FOUND_EXCEPTION_MESSAGE, workoutTemplateId))));
        templateExercise.setExercise(exerciseRepository.findById(exerciseId).orElseThrow(() -> new ExerciseNotFoundException(String.format(EXERCISE_NOT_FOUND_EXCEPTION_MESSAGE, exerciseId))));
        return templateExerciseMapper.toDTO(templateExerciseRepository.save(templateExercise));
    }

    @Transactional
    public void deleteAllById(List<Long> ids) {
        templateExerciseRepository.deleteAllById(ids);
    }

    @Transactional
    public void deleteById(Long id) {
        templateExerciseRepository.deleteById(id);
    }
}
