package com.user_bank_account.khayal.service;

import com.user_bank_account.khayal.dto.response.AccountResponseDto;
import com.user_bank_account.khayal.dto.request.BalanceRequestDto;
import com.user_bank_account.khayal.dto.request.CreateAccountRequestDto;
import com.user_bank_account.khayal.dto.request.TransferRequestDto;
import com.user_bank_account.khayal.entity.Account;
import com.user_bank_account.khayal.entity.User;
import com.user_bank_account.khayal.mapper.AccountMapper;
import com.user_bank_account.khayal.repository.AccountRepository;
import com.user_bank_account.khayal.repository.UserRepository;
import org.springframework.stereotype.*;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final AccountMapper accountMapper;
    private final CurrencyService currencyService;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository, AccountMapper accountMapper, CurrencyService currencyService) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.accountMapper = accountMapper;
        this.currencyService = currencyService;
    }

    public AccountResponseDto createAccount(CreateAccountRequestDto request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow();

        Account account = new Account();
        account.setUser(user);
        account.setCurrency(request.getCurrency());
        account.setBalance(request.getInitialBalance() != null ? request.getInitialBalance() : 0.0);
        account = accountRepository.save(account);
        return accountMapper.toDto(account);
    }

    public AccountResponseDto addBalance(BalanceRequestDto request) {
        Account accountDb = accountRepository.findById(request.getAccountId()).orElseThrow();
        accountDb.setBalance(accountDb.getBalance() + request.getAmount());
        Account account = accountRepository.save(accountDb);
        return accountMapper.toDto(account);
    }

    public AccountResponseDto getAccount(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        return accountMapper.toDto(account);
    }

    private double convert(double amount, String fromCurrency, String toCurrency, double rate) {
        if (fromCurrency.equals(toCurrency)) {
            return amount;
        }

        if ("AZN".equals(fromCurrency) && "USD".equals(toCurrency)) {
            return amount / rate;
        } else if ("USD".equals(fromCurrency) && "AZN".equals(toCurrency)) {
            return amount * rate;
        } else {
            throw new UnsupportedOperationException("Unsupported currency conversion: " + fromCurrency + " to " + toCurrency);
        }
    }

    public void transfer(TransferRequestDto request) {
        Account from = accountRepository.findById(request.getDebitAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Sender account not found"));
        Account to = accountRepository.findById(request.getCreditAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Receiver account not found"));

        double amount = request.getAmount();
        String requestCurrency = request.getCurrency();

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        double rate = currencyService.getUsdRate();
        double debitAmount = convert(amount, requestCurrency, from.getCurrency(), rate);
        double creditAmount = convert(amount, requestCurrency, to.getCurrency(), rate);

        if (from.getBalance() < debitAmount) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        from.setBalance(from.getBalance() - debitAmount);
        to.setBalance(to.getBalance() + creditAmount);

        accountRepository.save(from);
        accountRepository.save(to);
    }
}