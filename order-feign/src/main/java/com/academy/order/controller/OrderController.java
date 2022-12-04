package com.academy.order.controller;

import com.academy.order.openfeign.MailFeignService;
import com.academy.order.openfeign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {
    @Autowired
    private StockFeignService stockFeignService;
    @Autowired
    private MailFeignService mailFeignService;
    @Value("${useLocalCache:true}")
    private String useLocalCache;
    @Value("${server.port}")
    private String port;

    @RequestMapping("add")
    public String add() {
        String mailResult = mailFeignService.send("111233");
        String stockResult = stockFeignService.reduce();
        System.out.println("hello world " + stockResult + "/" + mailResult);
        return "hello world " + stockResult + "/" + mailResult + "---" + useLocalCache + "----"+port;
//        return "hello world " + stockResult + "/" ;
    }
}
