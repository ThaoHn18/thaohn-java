package com.thaohn.identity_service.mapper;

import com.thaohn.identity_service.dto.request.UserCreationRequest;
import com.thaohn.identity_service.dto.request.UserUpdateRequest;
import com.thaohn.identity_service.dto.response.UserResponse;
import com.thaohn.identity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse (User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
