package org.example.jisna.orderserviceapplication2.controller;


import org.example.jisna.orderserviceapplication2.Entity.*;
import org.example.jisna.orderserviceapplication2.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private MarketOrderRepository marketRepo;

    @Autowired
    private TransactionRepository transactionRepo;

    // 1. Order form page
    @GetMapping("/form")
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    // 2. Place Order
    @PostMapping("/place")
    public String placeOrder(@ModelAttribute Order order, Model model) {
        orderRepo.save(order);

        MarketOrder marketOrder = new MarketOrder();
        marketOrder.setStockSymbol(order.getStockSymbol());
        marketOrder.setQuantity(order.getQuantity());
        marketOrder.setOrderStatus("PLACED");
        marketRepo.save(marketOrder);

        Transaction transaction = new Transaction();
        transaction.setUserId(order.getUserId());
        transaction.setAmount(order.getQuantity() * 10); // Dummy price
        transaction.setDescription("Purchased " + order.getStockSymbol());
        transaction.setType("DEBIT");
        transactionRepo.save(transaction);

        model.addAttribute("order", order);
        return "orderConfirmation";
    }

    // 3. View all orders
    @GetMapping("/all")
    public String viewAllOrders(Model model) {
        List<Order> orders = orderRepo.findAll();
        model.addAttribute("orders", orders);
        return "allOrders";
    }

    // 4. Market Order form (optional)
    @GetMapping("/market-form")
    public String showMarketForm(Model model) {
        model.addAttribute("marketOrder", new MarketOrder());
        return "marketOrderForm";
    }

    // 5. View all market orders
    @GetMapping("/market-orders")
    public String viewMarketOrders(Model model) {
        List<MarketOrder> marketOrders = marketRepo.findAll();
        model.addAttribute("marketOrders", marketOrders);
        return "marketOrders";
    }

    // 6. View all transactions
    @GetMapping("/transactions")
    public String viewTransactions(Model model) {
        List<Transaction> transactions = transactionRepo.findAll();
        model.addAttribute("transactions", transactions);
        return "transactions"; // This should match your Thymeleaf template name
    }

}

