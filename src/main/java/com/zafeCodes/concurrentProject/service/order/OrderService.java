package com.zafeCodes.concurrentProject.service.order;

import com.zafeCodes.concurrentProject.model.basicData.Order;

public interface OrderService {
    Order submit(String orderId);

    void cancel(String orderId);

    void delete(String orderId);

    Order show(String orderId);
}
