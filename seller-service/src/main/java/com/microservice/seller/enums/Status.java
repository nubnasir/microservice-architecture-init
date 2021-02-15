package com.microservice.seller.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    ACTIVE(1),
    IN_ACTIVE(2);
    private Integer code;
}
