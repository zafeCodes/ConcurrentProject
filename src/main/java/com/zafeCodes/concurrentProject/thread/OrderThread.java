package com.zafeCodes.concurrentProject.thread;

import com.zafeCodes.concurrentProject.model.basicData.Order;

public class OrderThread implements Runnable{
    private Order order;

    public OrderThread(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        synchronized (order){
            while(order.getQuantity()>0){
                if(order.getQuantity()>0){
                    System.out.println("线程("+Thread.currentThread().getName()+")扣减了1个库存!剩余数量："+(order.getQuantity()-1));
                    order.setQuantity(order.getQuantity()-1);
                }
            }
            if(order.getQuantity()==0){
                System.out.println("线程("+Thread.currentThread().getName()+")扣减失败,库存数量不足");
            }
        }
    }
}
