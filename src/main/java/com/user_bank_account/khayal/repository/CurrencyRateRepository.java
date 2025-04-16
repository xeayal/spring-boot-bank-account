package com.user_bank_account.khayal.repository;

import com.user_bank_account.khayal.entity.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, String> {}