package com.zafeCodes.concurrentProject.model.basicData;

/**
 * 库存
 */
public class ProductStock {
    private Double quantity;

    private String goodId;

    public ProductStock(Double quantity, String goodId) {
        this.quantity = quantity;
        this.goodId = goodId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }
}
