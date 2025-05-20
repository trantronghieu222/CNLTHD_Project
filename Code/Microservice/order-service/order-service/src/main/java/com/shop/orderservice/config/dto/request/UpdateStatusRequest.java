package com.shop.orderservice.config.dto.request;

import com.shop.orderservice.config.common.OrderStatus;

public class UpdateStatusRequest {
    private OrderStatus orderStatus;

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
