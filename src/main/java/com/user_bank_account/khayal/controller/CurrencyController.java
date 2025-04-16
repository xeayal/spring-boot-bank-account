package com.user_bank_account.khayal.controller;

import com.user_bank_account.khayal.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/usd-rate")
    public Double getUsdRate() throws Exception {
        return currencyService.getUsdRate();
    }
}