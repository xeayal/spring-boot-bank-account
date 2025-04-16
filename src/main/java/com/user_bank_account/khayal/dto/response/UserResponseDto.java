package com.user_bank_account.khayal.dto.response;

import java.util.List;

public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private List<AccountResponseDto> accounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AccountResponseDto> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountResponseDto> accounts) {
        this.accounts = accounts;
    }
}
