package com.microservice.item.service;

import com.microservice.item.model.ItemInfo;
import com.microservice.item.model.Response;

public interface ItemService {
    Response<ItemInfo> getItemInfo(Long id);
    Response createItem(String name, String brand, Long sellerId);
}
