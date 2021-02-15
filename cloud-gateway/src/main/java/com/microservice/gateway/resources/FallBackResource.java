package com.microservice.gateway.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackResource {

    @GetMapping("/sellerServiceFallBack")
    public String sellerServiceFallBack(){
        return "Seller service not available";
    }
    @GetMapping("/itemServiceFallBack")
    public String itemServiceFallBack(){
        return "Item service not available";
    }
}
