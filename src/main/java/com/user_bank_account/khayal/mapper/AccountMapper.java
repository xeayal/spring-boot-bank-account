package com.user_bank_account.khayal.mapper;

import com.user_bank_account.khayal.dto.response.AccountResponseDto;
import com.user_bank_account.khayal.dto.response.AccountResponseDto;
import com.user_bank_account.khayal.entity.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountResponseDto toDto(Account entity);
    Account toEntity(AccountResponseDto dto);
    List<AccountResponseDto> toDtoList(List<Account> entities);
}
