package org.example.jisna.orderserviceapplication2.controller;

import org.example.jisna.orderserviceapplication2.Entity.Order;
import org.example.jisna.orderserviceapplication2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping
    public String placeOrder(@ModelAttribute Order order, Model model) {
        orderRepository.save(order);
        model.addAttribute("message", "Order placed successfully!");
        return "orderConfirmation";
    }

    // New method to view all orders
    @GetMapping("/all")
    public String viewAllOrders(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "allOrders"; // Name of the Thymeleaf template to render the orders
    }
}
