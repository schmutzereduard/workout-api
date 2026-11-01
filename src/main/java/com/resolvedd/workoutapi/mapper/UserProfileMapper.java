package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.UserProfileDTO;
import com.resolvedd.workoutapi.model.UserProfile;
import com.resolvedd.workoutapi.model.enums.UserGender;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.resolvedd.workoutapi.constants.ExceptionConstants.UNKNOWN_GENDER_EXCEPTION_MESSAGE_FORMAT;
import static com.resolvedd.workoutapi.constants.WorkoutConstants.GENDER_FEMALE;
import static com.resolvedd.workoutapi.constants.WorkoutConstants.GENDER_MALE;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {

    @Mapping(target = "metadata.id", source = "id")
    @Mapping(target = "metadata.clientId", source = "clientId")
    @Mapping(target = "metadata.createdAt", source = "createdAt")
    @Mapping(target = "metadata.updatedAt", source = "updatedAt")
    @Mapping(target = "metadata.deletedAt", source = "deletedAt")
    @Mapping(target = "gender", expression = "java(mapGenderToString(userProfile.getGender()))")
    UserProfileDTO toDTO(UserProfile userProfile);

    @Mapping(target = "id", source = "metadata.id")
    @Mapping(target = "clientId", source = "metadata.clientId")
    @Mapping(target = "createdAt", source = "metadata.createdAt")
    @Mapping(target = "updatedAt", source = "metadata.updatedAt")
    @Mapping(target = "deletedAt", source = "metadata.deletedAt")
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "gender", expression = "java(mapStringToGender(userProfileDTO.gender()))")
    UserProfile toEntity(UserProfileDTO userProfileDTO);

    default String mapGenderToString(UserGender gender) {
        if (gender == null) return null;
        return gender.getValue();
    }

    default UserGender mapStringToGender(String value) {
        if (value == null) return null;
        return switch (value) {
            case GENDER_MALE -> UserGender.MALE;
            case GENDER_FEMALE -> UserGender.FEMALE;
            default -> throw new IllegalArgumentException(String.format(UNKNOWN_GENDER_EXCEPTION_MESSAGE_FORMAT, value));
        };
    }
}
