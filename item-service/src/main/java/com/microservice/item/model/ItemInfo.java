package com.microservice.item.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemInfo {
    private String name;
    private String brand;
    private String sellerName;
    private String sellerAddress;
}
