package com.microservice.item.service.impl;

import com.microservice.item.configuration.thirdparty.SellerUrls;
import com.microservice.item.entity.Item;
import com.microservice.item.enums.ResponseCode;
import com.microservice.item.enums.ResponseMessage;
import com.microservice.item.enums.Status;
import com.microservice.item.model.ItemInfo;
import com.microservice.item.model.Response;
import com.microservice.item.model.thirdparty.SellerInfo;
import com.microservice.item.repository.ItemRepository;
import com.microservice.item.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final RestTemplate restTemplate;
    private final SellerUrls sellerUrls;

    public ItemServiceImpl(ItemRepository itemRepository,
                           RestTemplate restTemplate,
                           SellerUrls sellerUrls) {
        this.itemRepository = itemRepository;
        this.restTemplate = restTemplate;
        this.sellerUrls = sellerUrls;
    }

    @Transactional(readOnly = true)
    @Override
    public ItemInfo getItemInfo(Long id) {
        try {
            Item item = itemRepository.getOne(id);
            if (item != null) {
                SellerInfo sellerInfo = restTemplate
                        .getForObject(sellerUrls.getAppName() + String.format(sellerUrls.getInfoUrl(), item.getSellerId()),
                                SellerInfo.class);

                log.trace(id + " data accessed successfully");
                return new ItemInfo(item.getName(), item.getBrand(), sellerInfo.getName(), sellerInfo.getAddress());
            }
        } catch (javax.persistence.EntityNotFoundException exc){
            log.error(id + " data accessed failed");
        }

        return new ItemInfo("N/A", "N/A", "N/A", "N/A");
    }

    @Transactional
    @Override
    public Response createItem(String name, String brand, Long sellerId) {
        Item item = new Item();
        item.setName(name);
        item.setBrand(brand);
        item.setSellerId(sellerId);
        item.setStatus(Status.AVAILABLE.getCode());

        itemRepository.save(item);
        log.trace(name + " " + brand + " data created successfully");
        return new Response(ResponseCode.SUCCESS.getCode(), ResponseMessage.SUCCESS.getMessage());
    }
}
