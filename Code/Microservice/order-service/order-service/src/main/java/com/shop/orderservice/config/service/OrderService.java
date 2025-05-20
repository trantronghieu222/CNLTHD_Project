package com.shop.orderservice.config.service;

import com.shop.orderservice.config.dto.request.CreateOrderRequest;
import com.shop.orderservice.config.dto.request.UpdateStatusRequest;
import com.shop.orderservice.config.entity.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    List<Order> findAll();

    Order findById(Integer id);

    List<Order> findByCustomerId (Integer id);

//    Order save(Integer id, List<OrderDetail> orderDetails);

    Order createOrder(CreateOrderRequest createOrderRequest);

    Order updateStatus(Integer id, UpdateStatusRequest request);

    void deleteOrder(Integer id);

    Double getTotalRevenue(LocalDate from, LocalDate to);

    Long getOrderCountByDate(LocalDate date);
}
