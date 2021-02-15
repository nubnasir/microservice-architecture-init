package com.microservice.item.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMessage {
    SUCCESS("Successful"),
    FAILED("Failed");
    private String message;
}
