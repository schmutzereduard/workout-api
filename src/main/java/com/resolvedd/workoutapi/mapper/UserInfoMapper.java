package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.UserInfoDTO;
import com.resolvedd.workoutapi.exception.UnknownGenderException;
import com.resolvedd.workoutapi.model.UserGender;
import com.resolvedd.workoutapi.model.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.resolvedd.workoutapi.constants.ExceptionConstants.UNKNOWN_GENDER_EXCEPTION_MESSAGE_FORMAT;
import static com.resolvedd.workoutapi.constants.WorkoutConstants.GENDER_FEMALE;
import static com.resolvedd.workoutapi.constants.WorkoutConstants.GENDER_MALE;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {

    @Mapping(target = "gender", expression = "java(mapGenderToString(userInfo.getGender()))")
    UserInfoDTO toDTO(UserInfo userInfo);

    @Mapping(target = "gender", expression = "java(mapStringToGender(userInfoDTO.getGender()))")
    UserInfo toEntity(UserInfoDTO userInfoDTO);

    default String mapGenderToString(UserGender gender) {
        if (gender == null) return null;
        return gender.getValue();
    }

    default UserGender mapStringToGender(String value) {
        if (value == null) return null;
        return switch (value) {
            case GENDER_MALE -> UserGender.MALE;
            case GENDER_FEMALE -> UserGender.FEMALE;
            default -> throw new UnknownGenderException(String.format(UNKNOWN_GENDER_EXCEPTION_MESSAGE_FORMAT, value));
        };
    }
}
