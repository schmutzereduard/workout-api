package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.mapper.TemplateExerciseMapper;
import com.resolvedd.workoutapi.repository.ExerciseRepository;
import com.resolvedd.workoutapi.repository.TemplateExerciseRepository;
import com.resolvedd.workoutapi.repository.WorkoutTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TemplateExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final WorkoutTemplateRepository workoutTemplateRepository;
    private final TemplateExerciseRepository templateExerciseRepository;
    private final TemplateExerciseMapper templateExerciseMapper;
}
