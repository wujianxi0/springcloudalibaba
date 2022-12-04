package com.academy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "stock-seata", path = "/stock")
public interface StockFeignClient {

    @RequestMapping("/reduce")
    public int reduce(@RequestParam("productId") int productId, @RequestParam("count") int count);
}
