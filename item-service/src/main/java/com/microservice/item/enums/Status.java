package com.microservice.item.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    AVAILABLE(1),
    UNAVAILABLE(2);
    private Integer code;
}
