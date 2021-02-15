package com.microservice.seller.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMessage {
    SUCCESS("Successful"),
    FAILED("Failed"),
    NO_DATA("No data found");
    private String message;
}
