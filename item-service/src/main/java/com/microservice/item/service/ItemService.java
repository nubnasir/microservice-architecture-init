package com.microservice.item.service;

import com.microservice.item.model.ItemInfo;
import com.microservice.item.model.Response;

public interface ItemService {
    ItemInfo getItemInfo(Long id);
    Response createItem(String name, String brand, Long sellerId);
}
