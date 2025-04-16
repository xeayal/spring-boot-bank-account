package com.user_bank_account.khayal.exception;

import com.user_bank_account.khayal.dto.response.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiResponseDto<?>> handleNotFound(NoSuchElementException ex) {
        return new ResponseEntity<>(
                new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(), "Data not found", null),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponseDto<?>> handleBadRequest(IllegalArgumentException ex) {
        return new ResponseEntity<>(
                new ApiResponseDto<>(false, HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponseDto<?>> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<>(
                new ApiResponseDto<>(false, HttpStatus.BAD_REQUEST.value(), "Invalid parameter type", null),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseDto<?>> handleGeneral(Exception ex) {
        return new ResponseEntity<>(
                new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}