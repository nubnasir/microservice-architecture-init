package com.microservice.item.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
    SUCCESS(200),
    FAILED(500);
    private Integer code;
}
