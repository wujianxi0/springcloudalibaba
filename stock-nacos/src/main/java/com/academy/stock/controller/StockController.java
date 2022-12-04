package com.academy.stock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("reduce")
    public String reduce(){
        System.out.println("扣减库存！");
        return "扣减库存" + port;
    }


    @RequestMapping("reduce2")
    public String reduce2(@RequestParam("orderId") String orderId){
//        int i = 10 / 0;
        return "扣减库存" + orderId;
    }
}
