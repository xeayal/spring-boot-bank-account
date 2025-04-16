package com.user_bank_account.khayal.client;

import com.user_bank_account.khayal.model.ValCurs;
import com.user_bank_account.khayal.util.MapperUtil;
import com.user_bank_account.khayal.util.SSLUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${client.url.cbar}")
    private String cbarUrl;

    public ValCurs getCurrencyRates(String date) {
        SSLUtil.disableSSLVerification();
        String url = String.format(cbarUrl, date);
        String xmlResponse = restTemplate.getForObject(url, String.class);
        return MapperUtil.XmpParse(xmlResponse, ValCurs.class);
    }
}