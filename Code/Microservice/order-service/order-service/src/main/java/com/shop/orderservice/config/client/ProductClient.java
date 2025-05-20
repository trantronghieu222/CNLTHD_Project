package com.shop.orderservice.config.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service")
public interface ProductClient {
    @GetMapping("/product/{id}")
    void getProductById (@PathVariable Integer id);

    @GetMapping("/product/check-stock/{id}")
    Boolean checkStock(@PathVariable Integer id, @RequestParam Integer prodQuan);
}
