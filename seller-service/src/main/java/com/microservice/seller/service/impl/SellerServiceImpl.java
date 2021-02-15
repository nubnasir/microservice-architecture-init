package com.microservice.seller.service.impl;

import com.microservice.seller.entity.Seller;
import com.microservice.seller.enums.ResponseCode;
import com.microservice.seller.enums.ResponseMessage;
import com.microservice.seller.enums.Status;
import com.microservice.seller.model.Response;
import com.microservice.seller.model.SellerInfo;
import com.microservice.seller.repository.SellerRepository;
import com.microservice.seller.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public SellerInfo getSellerInfo(Long id) {
        try {
            Seller seller = sellerRepository.getOne(id);
            if (seller != null) {
                log.trace(id + " data accessed successfully");
                return new SellerInfo(seller.getName(), seller.getAddress());
            }
        } catch (javax.persistence.EntityNotFoundException exc){
            log.error(id + " data accessed failed");
        }

        return new SellerInfo("N/A", "N/A");
    }

    @Transactional
    @Override
    public Response createSeller(String name, String address) {
        Seller seller = new Seller();
        seller.setName(name);
        seller.setAddress(address);
        seller.setStatus(Status.ACTIVE.getCode());

        sellerRepository.save(seller);
        log.trace(name + " " + address + " data created successfully");
        return new Response(ResponseCode.SUCCESS.getCode(), ResponseMessage.SUCCESS.getMessage());
    }
}
