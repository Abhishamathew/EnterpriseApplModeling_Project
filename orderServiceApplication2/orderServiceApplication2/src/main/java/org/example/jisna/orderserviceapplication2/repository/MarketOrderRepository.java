package org.example.jisna.orderserviceapplication2.repository;


import org.example.jisna.orderserviceapplication2.Entity.*;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MarketOrderRepository extends MongoRepository<MarketOrder, String> {
}

