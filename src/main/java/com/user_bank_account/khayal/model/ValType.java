package com.user_bank_account.khayal.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class ValType {
    @JacksonXmlProperty(localName = "Type", isAttribute = true)
    private String type;

    @JacksonXmlProperty(localName = "Valute")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Valute> valute;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Valute> getValute() {
        return valute;
    }

    public void setValute(List<Valute> valute) {
        this.valute = valute;
    }
}