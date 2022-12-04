package com.academy.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    @Value("${server.port}")
    private String port;

    @RequestMapping("send/{orderId}")
    public String send(@PathVariable("orderId") String orderId){
        System.out.println("发送邮件！" + orderId);
        return orderId + "发送邮件" + port ;
    }
}
