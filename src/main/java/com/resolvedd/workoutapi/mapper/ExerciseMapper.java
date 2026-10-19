package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.ExerciseDTO;
import com.resolvedd.workoutapi.model.Exercise;
import com.resolvedd.workoutapi.model.MuscleGroup;
import com.resolvedd.workoutapi.model.MuscleGroupName;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {

    @Mapping(target = "metadata.id", source = "id")
    @Mapping(target = "metadata.clientId", source = "clientId")
    @Mapping(target = "metadata.createdAt", source = "createdAt")
    @Mapping(target = "metadata.updatedAt", source = "updatedAt")
    @Mapping(target = "metadata.deletedAt", source = "deletedAt")
    @Mapping(target = "muscleGroups", source = "muscleGroups")
    ExerciseDTO toDTO(Exercise exercise);

    @Mapping(target = "id", source = "metadata.id")
    @Mapping(target = "clientId", source = "metadata.clientId")
    @Mapping(target = "createdAt", source = "metadata.createdAt")
    @Mapping(target = "updatedAt", source = "metadata.updatedAt")
    @Mapping(target = "deletedAt", source = "metadata.deletedAt")
    @Mapping(target = "muscleGroups", source = "muscleGroups")
    @Mapping(target = "userId", ignore = true)
    Exercise toEntity(ExerciseDTO exerciseDTO);

    default String mapMuscleGroupToString(MuscleGroup muscleGroup) {
        if (muscleGroup == null || muscleGroup.getName() == null) {
            return null;
        }
        return muscleGroup.getName().getValue();
    }

    default MuscleGroup mapStringToMuscleGroup(String value) {
        if (value == null) {
            return null;
        }
        MuscleGroup muscleGroup = new MuscleGroup();
        muscleGroup.setName(MuscleGroupName.valueOf(value.toUpperCase()));
        return muscleGroup;
    }
}
