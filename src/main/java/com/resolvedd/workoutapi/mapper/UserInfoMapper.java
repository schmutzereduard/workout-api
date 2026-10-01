package com.resolvedd.workoutapi.mapper;

import com.resolvedd.workoutapi.dto.UserInfoDTO;
import com.resolvedd.workoutapi.model.UserInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {

    UserInfoDTO toDTO(UserInfo userInfo);
    UserInfo toEntity(UserInfoDTO userInfoDTO);
}
