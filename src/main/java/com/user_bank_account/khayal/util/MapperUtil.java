package com.user_bank_account.khayal.util;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.user_bank_account.khayal.model.ValCurs;

public class MapperUtil {
    public static <T> T XmpParse(String xml, Class<T> clazz){
        try{
            return new XmlMapper().readValue(xml, clazz);
        }catch (Exception ex){
            throw new IllegalArgumentException(ex);
        }
    }
}
