package com.academy.order.service;

import com.academy.order.entity.OrderEntity;

public interface IOrderService {
    int add(OrderEntity orderEntity);

    void create();
}
