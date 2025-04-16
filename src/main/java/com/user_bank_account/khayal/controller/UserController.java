package com.user_bank_account.khayal.controller;

import com.user_bank_account.khayal.dto.response.ApiResponseDto;
import com.user_bank_account.khayal.dto.response.UserResponseDto;
import com.user_bank_account.khayal.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponseDto<UserResponseDto>> createUser(@RequestBody UserResponseDto dto) {
        UserResponseDto user = userService.createUser(dto);
        return ResponseEntity.ok(new ApiResponseDto<>(true, HttpStatus.OK.value(), "User created successfully", user));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponseDto<UserResponseDto>> updateUser(@PathVariable Long id, @RequestBody UserResponseDto dto) {
        UserResponseDto user = userService.updateUser(id, dto);
        return ResponseEntity.ok(new ApiResponseDto<>(true, HttpStatus.OK.value(), "User updated successfully", user));
    }

    @GetMapping("/get-all")
    public ResponseEntity<ApiResponseDto<List<UserResponseDto>>> getUsers() {
        List<UserResponseDto> users = userService.getUsers();
        return ResponseEntity.ok(new ApiResponseDto<>(true, HttpStatus.OK.value(), "Users retrieved successfully", users));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponseDto<UserResponseDto>> getUser(@PathVariable Long id) {
        UserResponseDto user = userService.getUser(id);
        return ResponseEntity.ok(new ApiResponseDto<>(true, HttpStatus.OK.value(), "User retrieved successfully", user));
    }

    @GetMapping("/get-balance/{id}")
    public ResponseEntity<ApiResponseDto<Double>> getUserBalance(@PathVariable Long id) {
        Double balance = userService.getUserBalance(id);
        return ResponseEntity.ok(new ApiResponseDto<>(true, HttpStatus.OK.value(), "User balance retrieved successfully", balance));
    }
}
