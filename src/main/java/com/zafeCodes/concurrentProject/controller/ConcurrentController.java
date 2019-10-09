package com.zafeCodes.concurrentProject.controller;

import com.alibaba.fastjson.JSONObject;
import com.zafeCodes.concurrentProject.model.basicData.Order;
import com.zafeCodes.concurrentProject.service.order.OrderService;
import com.zafeCodes.concurrentProject.thread.OrderThread;
import com.zafeCodes.concurrentProject.thread.ThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value="/concurrent")
public class ConcurrentController {
    @Autowired
    ThreadPoolExecutor threadPoolExecutor;
    @Autowired
    OrderService orderService;
    @RequestMapping(value="/submit")
    public void submit(@RequestParam(value="orderId")String orderId){
        orderService.submit(orderId);
    }

    @RequestMapping(value="/cancel")
    public void cancel(@RequestParam(value="orderId")String orderId){
        orderService.cancel(orderId);
    }

    @RequestMapping(value="/finish")
    public void finish(@RequestParam(value="orderId")String orderId){

    }

    @RequestMapping(value="/show")
    public void show(@RequestParam(value="orderId")String orderId){
        Order order = orderService.show(orderId);
        System.out.println("订单信息："+JSONObject.toJSON(order).toString());
    }

    public static void main(String[] args){
        OrderThread orderThread = new OrderThread(new Order("123",100D,"123"));
        new Thread(orderThread,"Thread1").start();
        new Thread(orderThread,"Thread2").start();
        new Thread(orderThread,"Thread3").start();
    }

    @RequestMapping(value="execute")
    public void execute(){
        threadPoolExecutor.execute();
    }

}
