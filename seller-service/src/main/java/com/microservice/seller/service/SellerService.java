package com.microservice.seller.service;

import com.microservice.seller.model.Response;
import com.microservice.seller.model.SellerInfo;

public interface SellerService {
    Response<SellerInfo> getSellerInfo(Long id);
    Response createSeller(String name, String address);
}
