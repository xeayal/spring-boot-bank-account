package com.user_bank_account.khayal.mapper;

import com.user_bank_account.khayal.dto.response.UserResponseDto;
import com.user_bank_account.khayal.dto.response.UserResponseDto;
import com.user_bank_account.khayal.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto toDto(User entity);
    User toEntity(UserResponseDto dto);
    List<UserResponseDto> toDtoList(List<User> entities);
}
