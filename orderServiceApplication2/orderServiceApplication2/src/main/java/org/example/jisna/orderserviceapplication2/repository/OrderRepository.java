package org.example.jisna.orderserviceapplication2.repository;


import org.example.jisna.orderserviceapplication2.Entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> { }

