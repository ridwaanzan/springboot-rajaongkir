package com.excercise.inteceptor.services;

import com.excercise.inteceptor.dto.ROCostResultDto;
import com.excercise.inteceptor.dto.RajaOngkirCostDtoRequest;
import com.excercise.inteceptor.dto.RajaOngkirCostDtoResponse;
import com.excercise.inteceptor.utils.HttpRequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class RajaOngkirService {

    private final HttpRequestUtil httpRequest;

    @Value("${rajaongkir.api.key}")
    private String rajaongkirApiKey;

    @Value("${rajaongkir.cost.url}")
    private String rajaongkirCostUrl;

    public RajaOngkirService() {
        this.httpRequest = new HttpRequestUtil();
    }

    public List<ROCostResultDto> getShippingCost(RajaOngkirCostDtoRequest request) {
        log.info("==== Request: {}", request);
        HttpHeaders headers = createHeaders();

        // request body
        MultiValueMap<String, String> reqBody = new LinkedMultiValueMap<>();
        reqBody.add("origin", String.valueOf(request.getOrigin()));
        reqBody.add("destination", String.valueOf(request.getDestination()));
        reqBody.add("weight", String.valueOf(request.getWeight()));
        reqBody.add("courier", request.getCourier());

        RajaOngkirCostDtoResponse response = httpRequest.httpPost(rajaongkirCostUrl,
                                                                  HttpMethod.POST,
                                                                  new HttpEntity<>(reqBody, headers),
                                                                  RajaOngkirCostDtoResponse.class);
        log.info("==== RajaOngkirResponse: {}", response);

        return response.getRajaongkir().getResults();
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("key", rajaongkirApiKey);

        return headers;
    }

}
