package com.resolvedd.workoutapi.service;

import com.resolvedd.workoutapi.dto.WorkoutTemplateDTO;
import com.resolvedd.workoutapi.exception.MesocycleNotFoundException;
import com.resolvedd.workoutapi.mapper.WorkoutTemplateMapper;
import com.resolvedd.workoutapi.model.WorkoutTemplate;
import com.resolvedd.workoutapi.repository.MesocycleRepository;
import com.resolvedd.workoutapi.repository.WorkoutTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.resolvedd.workoutapi.constants.ExceptionConstants.MESOCYCLE_NOT_FOUND_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class WorkoutTemplateService {

    private final MesocycleRepository mesocycleRepository;
    private final WorkoutTemplateRepository workoutTemplateRepository;
    private final WorkoutTemplateMapper workoutTemplateMapper;

    public List<WorkoutTemplateDTO> findAllByMesocycleId(Long mesocycleId) {
        return workoutTemplateRepository.findAllByMesocycleId(mesocycleId).stream()
                .map(workoutTemplateMapper::toDTO)
                .toList();
    }

    @Transactional
    public WorkoutTemplateDTO save(WorkoutTemplateDTO workoutTemplateDTO) {
        WorkoutTemplate workoutTemplate = workoutTemplateMapper.toEntity(workoutTemplateDTO);
        Long mesocycleId = workoutTemplateDTO.getMesocycleId();
        workoutTemplate.setMesocycle(mesocycleRepository.findById(mesocycleId).orElseThrow(() -> new MesocycleNotFoundException(String.format(MESOCYCLE_NOT_FOUND_EXCEPTION_MESSAGE, mesocycleId))));
        return workoutTemplateMapper.toDTO(workoutTemplateRepository.save(workoutTemplate));
    }

    @Transactional
    public void deleteAllById(List<Long> ids) {
        workoutTemplateRepository.deleteAllById(ids);
    }

    @Transactional
    public void deleteById(Long id) {
        workoutTemplateRepository.deleteById(id);
    }
}
