package com.microservice.item.configuration;

import com.microservice.item.configuration.thirdparty.SellerUrls;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:props/seller.urls.properties")})
public class PropertiesLoader {
    @Value("${seller.app.name}")
    private String sellerAppName;
    @Value("${seller.info}")
    private String sellerInfoUrl;

    @Bean
    public SellerUrls sellerUrls(@Value("${seller.app.name}") String sellerAppName,
                                         @Value("${seller.info}") String sellerInfoUrl){
        return new SellerUrls(sellerAppName, sellerInfoUrl);
    }


}
