package com.academy.stock.controller;

import com.academy.stock.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    IStockService stockService;

    @RequestMapping("/reduce")
    public int reduce(@RequestParam("productId") int productId, @RequestParam("count")int reduceCount){
        int reduce = stockService.reduce(productId, reduceCount);
        return reduce;
    }
}
