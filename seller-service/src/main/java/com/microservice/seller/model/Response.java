package com.microservice.seller.model;

import com.microservice.seller.enums.ResponseCode;
import com.microservice.seller.enums.ResponseMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Response {
    private Integer code;
    private String message;
}
