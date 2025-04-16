package com.user_bank_account.khayal.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class CurrencyRate {
    @Id
    private String code;
    private Double value;
    private LocalDate updatedDate;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }
}