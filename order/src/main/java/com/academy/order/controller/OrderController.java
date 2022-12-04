package com.academy.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("add")
    public String add() {
        String result = restTemplate.getForObject("http://localhost:8081/stock/reduce", String.class);
        System.out.println("hello world " + result);
        return "hello world " + result;
    }

    @RequestMapping("/gateway/filter/test")
    public String gatewayFilterTest(HttpServletRequest request){
        return request.getHeader("X-Request-Id");
    }
}
