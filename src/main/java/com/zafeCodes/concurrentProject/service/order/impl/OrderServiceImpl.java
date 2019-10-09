package com.zafeCodes.concurrentProject.service.order.impl;

import com.alibaba.fastjson.JSONObject;
import com.zafeCodes.concurrentProject.model.basicData.Order;
import com.zafeCodes.concurrentProject.service.order.OrderService;
import com.zafeCodes.concurrentProject.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    RedisUtil redisUtil;
    @Override
    @Cacheable(value={"order"},key="'order'+#orderId")
    public Order submit(String orderId) {
        Order order = new Order(orderId,2D,"110");
        System.out.println("-----------订单号："+ order.getOrderId()+"已经进入系统>>>>>>>");
//        redisUtil.set(orderId,order);
        return order;
    }

    @Override
    @CacheEvict(key = "#orderId")
    public void cancel(String orderId) {
        Order order = new Order(orderId,2D,"110");
        System.out.println("-----------订单号："+ order.getOrderId()+"已经取消>>>>>>>");
    }

    @Override
    public void delete(String orderId) {

    }


    @Cacheable(value={"order"},key="'order'+#orderId")
    public Order show(String orderId) {
        Order order = new Order("0",0D,"0");
//        redisUtil.set(orderId,order);
        return order;
    }


}
