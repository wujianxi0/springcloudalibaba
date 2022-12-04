package com.academy.stock.entity;

public class StockEntity {
    private int id;
    private int productId;
    private int reduceCount;

    private int totalCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getReduceCount() {
        return reduceCount;
    }

    public void setReduceCount(int reduceCount) {
        this.reduceCount = reduceCount;
    }
}
