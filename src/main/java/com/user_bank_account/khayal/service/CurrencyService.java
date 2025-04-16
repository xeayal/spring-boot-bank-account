package com.user_bank_account.khayal.service;

import com.user_bank_account.khayal.client.CurrencyClient;
import com.user_bank_account.khayal.model.ValCurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyClient currencyClient;

    @Cacheable("usdRates")
    public double getUsdRate(){
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        ValCurs valCurs = currencyClient.getCurrencyRates(date);

        return valCurs.getValType().stream()
                .filter(type -> type.getType().equalsIgnoreCase("Xarici valyutalar"))
                .flatMap(type -> type.getValute().stream())
                .filter(valute -> valute.getCode().equalsIgnoreCase("USD"))
                .findFirst()
                .map(valute -> Double.parseDouble(valute.getValue().replace(",", ".")))
                .orElseThrow(() -> new RuntimeException("USD rate not found"));
    }

    @CacheEvict(value = "usdRates", allEntries = true)
    @Scheduled(cron = "0 0 0 * * *")
    public void evictUsdRatesCache() {
        System.out.println("usdRates cache resetləndi!");
    }
}