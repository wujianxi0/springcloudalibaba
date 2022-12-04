package com.academy.order.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "stock-service", path = "/stock")
public interface StockFeignService {

    @RequestMapping("reduce")
    public String reduce();
}
