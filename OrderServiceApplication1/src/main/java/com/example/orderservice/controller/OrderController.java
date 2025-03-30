package com.example.orderservice.controller;

import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    // Create and save an order
    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        Order savedOrder = orderRepository.save(order);
        System.out.println("Saved Order: " + savedOrder); // Debugging
        return savedOrder;
    }

    // Retrieve all orders
    @GetMapping
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}
