package com.microservice.seller.service;

import com.microservice.seller.model.Response;
import com.microservice.seller.model.SellerInfo;

public interface SellerService {
    SellerInfo getSellerInfo(Long id);
    Response createSeller(String name, String address);
}
