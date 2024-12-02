package com.appaces.ecommerce.service.product;

import com.appaces.ecommerce.dto.PurchaseRequest;
import com.appaces.ecommerce.dto.PurchaseResponse;
import com.appaces.ecommerce.utils.exceptions.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@RequiredArgsConstructor
public class ProductClient {
    @Value("${application.config.product-url}")
    private String productUrl;

    private final RestTemplate restTemplate;

    public List<PurchaseResponse> purchaseProucts(List<PurchaseRequest> request){
        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.set(CONTENT_TYPE, APPLICATION_JSON_VALUE);
        HttpEntity<List<PurchaseRequest>> requestEntity = new HttpEntity<>(request,headers);
        ParameterizedTypeReference<List<PurchaseResponse>> responseType = new ParameterizedTypeReference<List<PurchaseResponse>>() {};
        ResponseEntity<List<PurchaseResponse>> response = restTemplate.exchange(
                productUrl+"/purchase",
                POST,
                requestEntity,
                responseType
        );
        if (response.getStatusCode().isError()){
            throw new CustomException("Error: An Error occurred while processing product purchase with code: "+response.getStatusCode());
        }
        return response.getBody();
    }
}
