package com.user_bank_account.khayal.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Valute {
    @JacksonXmlProperty(localName = "Code", isAttribute = true)
    private String code;

    @JacksonXmlProperty(localName = "Nominal")
    private String nominal;

    @JacksonXmlProperty(localName = "Name")
    private String name;

    @JacksonXmlProperty(localName = "Value")
    private String value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}