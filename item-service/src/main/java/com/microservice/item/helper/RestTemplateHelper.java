package com.microservice.item.helper;

import com.microservice.item.model.Response;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class RestTemplateHelper {
    public static HttpEntity<Object> getHttpEntityRequest(Object data){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if(data != null)
            return new HttpEntity<>(data, headers);
        return new HttpEntity<>(headers);
    }

    public static Response getBody(RestTemplate restTemplate, String url, Object data, ParameterizedTypeReference parameterizedTypeReference){
        ResponseEntity<Response> responseEntity = restTemplate.exchange(url, HttpMethod.POST, getHttpEntityRequest(data), parameterizedTypeReference);
        return responseEntity.getBody();
    }
}
