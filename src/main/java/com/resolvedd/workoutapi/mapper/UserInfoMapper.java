package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.UserInfoDTO;
import com.resolvedd.workoutapi.model.MesocycleStatus;
import com.resolvedd.workoutapi.model.UserGender;
import com.resolvedd.workoutapi.model.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {

    @Mapping(target = "gender", expression = "java(mapGenderToString(userInfo.getGender()))")
    UserInfoDTO toDTO(UserInfo userInfo);

    @Mapping(target = "gender", expression = "java(mapStringToGender(userInfoDTO.getGender()))")
    UserInfo toEntity(UserInfoDTO userInfoDTO);

    default String mapGenderToString(UserGender gender) {
        if (gender == null) return null;
        return switch (gender) {
            case MALE -> "M";
            case FEMALE -> "F";
        };
    }

    default UserGender mapStringToGender(String value) {
        if (value == null) return null;
        return switch (value) {
            case "M" -> UserGender.MALE;
            case "F" -> UserGender.FEMALE;
            default -> throw new IllegalArgumentException("Unexpected status: " + value);
        };
    }
}
