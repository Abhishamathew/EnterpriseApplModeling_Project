package com.example.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

@EnableDiscoveryClient
public class OrderServiceApplication1Application {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication1Application.class, args);
	}

}
