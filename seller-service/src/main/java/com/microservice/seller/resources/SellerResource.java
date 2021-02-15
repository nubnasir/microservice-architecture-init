package com.microservice.seller.resources;

import com.microservice.seller.model.Response;
import com.microservice.seller.model.SellerInfo;
import com.microservice.seller.service.SellerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerResource extends BaseResource{
    private final SellerService sellerService;

    public SellerResource(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/info/{id}")
    public SellerInfo getSellerInfo(@PathVariable("id") Long id){
        return sellerService.getSellerInfo(id);
    }

    @PostMapping("/info")
    public Response getSellerInfo(SellerInfo sellerInfo){
        return sellerService.createSeller(sellerInfo.getName(), sellerInfo.getAddress());
    }
}
