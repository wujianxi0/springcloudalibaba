package com.academy.stock.mapper;

import com.academy.stock.entity.StockEntity;
import org.apache.ibatis.annotations.Param;

public interface StockMapper {
    int reduce(@Param("stock") StockEntity stockEntity);
}
