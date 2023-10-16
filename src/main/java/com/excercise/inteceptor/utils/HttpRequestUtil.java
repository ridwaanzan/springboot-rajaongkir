package com.excercise.inteceptor.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpRequestUtil {
    private final RestTemplate restTemplate;

    public HttpRequestUtil() {
        this.restTemplate = new RestTemplate();
    }

    public <T> T httpPost(String baseUrl,
                          HttpMethod method,
                          HttpEntity<?> entity,
                          Class<T> responseType) {
        ResponseEntity<T> responseEntity = restTemplate.exchange(baseUrl,
                                                                method,
                                                                entity,
                                                                responseType);
        return responseEntity.getBody();
    }
}
