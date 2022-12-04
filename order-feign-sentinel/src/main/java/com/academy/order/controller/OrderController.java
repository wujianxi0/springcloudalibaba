package com.academy.order.controller;

import com.academy.order.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private StockFeignService stockFeignService;

    @RequestMapping("/add")
    public String add(){
        String orderId = "OD001";
        String reduce = stockFeignService.reduce(orderId);
        return orderId + "-" + reduce;
    }
}
