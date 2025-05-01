package com.shop.watch.controller;

import com.shop.watch.model.OrderModel;
import com.shop.watch.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/Order")
@Tag(name = "Order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderModel>> getAllOrder(){
        return ResponseEntity.ok(orderService.getAllOrder());
    }

    @PostMapping
    public ResponseEntity<OrderModel> createOrder(@RequestBody OrderModel orderModel){
        OrderModel order = orderService.createOrder(orderModel);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@RequestParam Integer id){
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
