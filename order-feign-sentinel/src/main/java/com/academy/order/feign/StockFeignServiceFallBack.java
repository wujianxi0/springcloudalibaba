package com.academy.order.feign;

import org.springframework.stereotype.Component;

@Component
public class StockFeignServiceFallBack implements StockFeignService {

    public String reduce() {
        return "服务降级了";
    }

    public String reduce(String orderId) {
        return orderId + "服务降级了";
    }
}
