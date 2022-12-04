package com.academy.order.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "stock-service", path = "/stock", fallback = StockFeignServiceFallBack.class)
public interface StockFeignService {

    /*@RequestMapping("/reduce2")
    public String reduce();*/

    @RequestMapping("/reduce2")
    public String reduce(@RequestParam("orderId") String orderId);
}
