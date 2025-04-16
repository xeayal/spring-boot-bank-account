package com.user_bank_account.khayal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ValCurs {
    @JacksonXmlProperty(localName = "Date", isAttribute = true)
    private String date;

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    private String name;

    @JacksonXmlProperty(localName = "Description", isAttribute = true)
    private String description;

    @JacksonXmlProperty(localName = "ValType")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<ValType> valType;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ValType> getValType() {
        return valType;
    }

    public void setValType(List<ValType> valType) {
        this.valType = valType;
    }
}