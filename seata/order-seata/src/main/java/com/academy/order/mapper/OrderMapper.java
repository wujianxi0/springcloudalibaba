package com.academy.order.mapper;

import com.academy.order.entity.OrderEntity;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    public int save(@Param("order") OrderEntity orderEntity);
}
