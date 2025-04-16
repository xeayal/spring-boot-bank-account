package com.user_bank_account.khayal.controller;

import com.user_bank_account.khayal.dto.request.BalanceRequestDto;
import com.user_bank_account.khayal.dto.request.CreateAccountRequestDto;
import com.user_bank_account.khayal.dto.request.TransferRequestDto;
import com.user_bank_account.khayal.dto.response.AccountResponseDto;
import com.user_bank_account.khayal.dto.response.ApiResponseDto;
import com.user_bank_account.khayal.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponseDto<AccountResponseDto>> createAccount(@RequestBody CreateAccountRequestDto request) {
        AccountResponseDto account = accountService.createAccount(request);
        return ResponseEntity.ok(new ApiResponseDto<>(true, HttpStatus.OK.value(), "Account created", account));
    }

    @PostMapping("/add-balance")
    public ResponseEntity<ApiResponseDto<AccountResponseDto>> addBalance(@RequestBody BalanceRequestDto request) {
        AccountResponseDto account = accountService.addBalance(request);
        return ResponseEntity.ok(new ApiResponseDto<>(true,  HttpStatus.OK.value(), "Balance added", account));
    }

    @GetMapping("/get/{accountId}")
    public ResponseEntity<ApiResponseDto<AccountResponseDto>> getAccount(@PathVariable Long accountId) {
        AccountResponseDto account = accountService.getAccount(accountId);
        return ResponseEntity.ok(new ApiResponseDto<>(true,  HttpStatus.OK.value(), "Account retrieved", account));
    }

    @PostMapping("/transfer")
    public ResponseEntity<ApiResponseDto<String>> transfer(@RequestBody TransferRequestDto request) {
        accountService.transfer(request);
        return ResponseEntity.ok(new ApiResponseDto<>(true,  HttpStatus.OK.value(), "Transfer completed", null));
    }
}