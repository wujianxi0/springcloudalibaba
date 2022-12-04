package com.academy.order.controller;

import com.academy.order.service.IUserService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderSentinelController {
    public static final String ADD="add";
    public static final String SUBTRACT="subtract";

    @Autowired
    private IUserService userService;

    @RequestMapping("/get")
    public String get(){
        String result = "查看订单";
        String user = userService.get();
        return result + user;
    }

    @RequestMapping("add")
//    @SentinelResource(value = ADD, blockHandler = "addBlockHandle")
    public String add() {
        String result = "添加订单";
        String user = userService.get();
        return result+user;
    }
    @RequestMapping("subtract")
//    @SentinelResource(value = SUBTRACT, blockHandler = "subtractBlockHandle")
    public String subtract() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String result = "删除订单";
        return result;
    }

    private String subtractBlockHandle(BlockException blockException){
        return "subtractBlockHandle：sentinel block handed";
    }
    private String addBlockHandle(BlockException blockException){
        return "addBlockHandle：sentinel block handed";
    }
}
