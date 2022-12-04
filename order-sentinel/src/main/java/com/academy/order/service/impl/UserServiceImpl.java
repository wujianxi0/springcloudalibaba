package com.academy.order.service.impl;

import com.academy.order.service.IUserService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements IUserService {
    @SentinelResource(value = "getUser", blockHandler = "getUser")
    public String get() {
        return "user zhangsan";
    }

    public String getUser(BlockException blockException){
        return "getUser block";
    }
}
