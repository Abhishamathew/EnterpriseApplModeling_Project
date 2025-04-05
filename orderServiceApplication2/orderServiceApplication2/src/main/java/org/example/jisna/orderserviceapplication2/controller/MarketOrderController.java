package org.example.jisna.orderserviceapplication2.controller;


import org.example.jisna.orderserviceapplication2.Entity.MarketOrder;
import org.example.jisna.orderserviceapplication2.Entity.Transaction;
import org.example.jisna.orderserviceapplication2.repository.MarketOrderRepository;
import org.example.jisna.orderserviceapplication2.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MarketOrderController {

    @Autowired
    private MarketOrderRepository marketOrderRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    // Show form to place new market order
    @GetMapping("/market-orders/new")
    public String showMarketOrderForm(Model model) {
        model.addAttribute("marketOrder", new MarketOrder());
        return "marketOrderForm";
    }

    // Submit new market order
    @PostMapping("/market-orders")
    public String placeMarketOrder(@ModelAttribute MarketOrder marketOrder) {
        marketOrderRepository.save(marketOrder);
        return "redirect:/market-orders";
    }

    // Show all market orders
    @GetMapping("/market-orders")
    public String viewMarketOrders(Model model) {
        model.addAttribute("marketOrders", marketOrderRepository.findAll());
        return "marketOrders";
    }

    // Show all transactions
    @GetMapping("/transactions")
    public String viewTransactions(Model model) {
        model.addAttribute("transactions", transactionRepository.findAll());
        return "transactions";
    }
}

