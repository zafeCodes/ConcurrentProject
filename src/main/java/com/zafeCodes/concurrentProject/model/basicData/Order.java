package com.zafeCodes.concurrentProject.model.basicData;

import java.io.Serializable;

/**
 * 订单
 */
public class Order implements Serializable {
    private String orderId;
    private Double quantity;
    private String goodId;
    public Order(){

    }
    public Order(String orderId, Double quantity, String goodId) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.goodId = goodId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
