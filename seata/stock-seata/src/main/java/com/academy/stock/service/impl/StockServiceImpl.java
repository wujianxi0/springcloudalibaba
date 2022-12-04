package com.academy.stock.service.impl;

import com.academy.stock.entity.StockEntity;
import com.academy.stock.mapper.StockMapper;
import com.academy.stock.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements IStockService {
    @Autowired
    StockMapper stockMapper;
    @Override
    public int reduce(int productId, int reduceCount) {
        StockEntity stockEntity = new StockEntity();
        stockEntity.setReduceCount(reduceCount);
        stockEntity.setProductId(productId);
        int i = stockMapper.reduce(stockEntity);
        return i;
    }
}
