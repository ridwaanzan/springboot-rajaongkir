package com.excercise.inteceptor.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;

@Configuration
@Slf4j
public class RestTemplateConfig {
    private final Environment environment;

    public RestTemplateConfig(Environment environment) {
        this.environment = environment;
        log.info("==== RestTemplateConfig is loaded.");
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
        restTemplate.setInterceptors(Collections.singletonList(new RajaOngkirHeaderInterceptor(environment)));

        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        return new SimpleClientHttpRequestFactory();
    }
}

@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
class RajaOngkirHeaderInterceptor implements ClientHttpRequestInterceptor {
    private final Environment environment;

    public RajaOngkirHeaderInterceptor(Environment environment) {
        this.environment = environment;
        log.info("==== RajaOngkirHeaderInterceptor is loaded");
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        String apiKey = environment.getProperty("rajaongkir.api.key");

        request.getHeaders().set("key", apiKey);
        request.getHeaders().set("content-type", "application/x-www-form-urlencoded");
        log.info("==== Interceptor is running");

        return execution.execute(request, body);
    }
}
