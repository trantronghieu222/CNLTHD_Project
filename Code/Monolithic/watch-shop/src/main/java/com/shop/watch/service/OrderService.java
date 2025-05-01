package com.shop.watch.service;

import com.shop.watch.model.OrderModel;
import com.shop.watch.repository.OrderRepository;
import com.shop.watch.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<OrderModel> getAllOrder(){
        return orderRepository.findAll();
    }

    public OrderModel createOrder(OrderModel orderModel){
        return orderRepository.save(orderModel);
    }

    public void deleteOrder(Integer id){
        orderRepository.deleteById(id);
    }
}
