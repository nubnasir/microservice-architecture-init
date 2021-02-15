package com.microservice.seller.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
    SUCCESS(200),
    FAILED(201),
    NO_DATA(202);
    private Integer code;
}
