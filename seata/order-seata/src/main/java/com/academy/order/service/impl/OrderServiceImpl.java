package com.academy.order.service.impl;

import com.academy.feign.StockFeignClient;
import com.academy.order.entity.OrderEntity;
import com.academy.order.mapper.OrderMapper;
import com.academy.order.service.IOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StockFeignClient stockFeignClient;

    public int add(OrderEntity orderEntity) {
        return orderMapper.save(orderEntity);
    }

//    @Transactional
    @GlobalTransactional
    public void create() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderNo("ONO001");
        orderEntity.setId(new Random().nextInt());
        orderEntity.setProductId(111);
        orderEntity.setCount(1);
        add(orderEntity);

        int reduce = stockFeignClient.reduce(orderEntity.getProductId(), orderEntity.getCount());
//        int i = 10 / 0;
    }
}
