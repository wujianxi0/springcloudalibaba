package com.academy.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("add")
    public String add() {
        String stockResult = restTemplate.getForObject("http://stock-service/stock/reduce", String.class);
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("orderId", "123");
        String mailResult = restTemplate.getForObject("http://mail-service/mail/send/{orderId}", String.class, params);
        System.out.println("hello world " + stockResult + "/" + mailResult);
        return "hello world " + stockResult + "/" + mailResult;
    }
}
