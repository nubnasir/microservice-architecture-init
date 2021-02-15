package com.microservice.seller.model;

import com.microservice.seller.enums.ResponseCode;
import com.microservice.seller.enums.ResponseMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private Integer code;
    private String message;
    private T payload;
}
