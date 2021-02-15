package com.microservice.item.resources;

import com.microservice.item.model.ItemInfo;
import com.microservice.item.model.Response;
import com.microservice.item.model.SaveItem;
import com.microservice.item.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemResource extends BaseResource {
    private final ItemService itemService;

    public ItemResource(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/info/{id}")
    public ItemInfo getSellerInfo(@PathVariable("id") Long id){
        return itemService.getItemInfo(id);
    }

    @PostMapping("/info/{sellerId}")
    public Response getSellerInfo(@PathVariable Long sellerId, SaveItem saveItem){
        return itemService.createItem(saveItem.getName(), saveItem.getBrand(), sellerId);
    }
}
