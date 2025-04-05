package org.example.jisna.orderserviceapplication2.controller;


import org.example.jisna.orderserviceapplication2.Entity.*;
import org.example.jisna.orderserviceapplication2.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository repo;

    @PostMapping("/debit")
    public Transaction debit(@RequestBody Transaction tx) {
        tx.setType("DEBIT");
        return repo.save(tx);
    }
}

