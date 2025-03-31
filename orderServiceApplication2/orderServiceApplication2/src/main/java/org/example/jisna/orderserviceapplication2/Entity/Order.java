package org.example.jisna.orderserviceapplication2.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private String userId;
    private String stockSymbol;
    private double quantity; // Corrected to use double for decimals

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getStockSymbol() { return stockSymbol; }
    public void setStockSymbol(String stockSymbol) { this.stockSymbol = stockSymbol; }

    public double getQuantity() { return quantity; } // Fixed to return double instead of int
    public void setQuantity(double quantity) { this.quantity = quantity; } // Fixed to accept double
}
