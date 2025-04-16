package com.user_bank_account.khayal.service;

import com.user_bank_account.khayal.dto.response.UserResponseDto;
import com.user_bank_account.khayal.entity.Account;
import com.user_bank_account.khayal.entity.User;
import com.user_bank_account.khayal.mapper.UserMapper;
import com.user_bank_account.khayal.repository.UserRepository;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDto createUser(UserResponseDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserResponseDto updateUser(Long id, UserResponseDto dto) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public List<UserResponseDto> getUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDtoList(users);
    }

    public UserResponseDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return userMapper.toDto(user);
    }

    public Double getUserBalance(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return user.getAccounts().stream().mapToDouble(Account::getBalance).sum();
    }

}
