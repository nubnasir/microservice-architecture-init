package com.microservice.item.enums;

import com.microservice.item.model.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
    SUCCESS(200),
    FAILED(201),
    NO_DATA(202);
    private Integer code;

    public static boolean isSuccess(Response response){
        return response.getCode() == ResponseCode.SUCCESS.getCode();
    }
}
