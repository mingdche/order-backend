package com.example.orderbackend.api;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.orderbackend.application.service.OrderService;
import com.example.orderbackend.application.dto.OrderResponse;
import com.example.orderbackend.domain.model.OrderItem;

import lombok.Data;

import java.util.List;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/orders")
public class OrderResources {

    private final OrderService orderService;

    @Autowired
    public OrderResources(OrderService orderService) {
        this.orderService = orderService;
    }
    
    @Value("${mall_backend_service_url}")
    private String productApiUrl;

    @GetMapping
    public String getAll(){
        System.out.println("spring boot running");
        return  "spring is running";
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
        OrderResponse order = orderService.getOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderRequest request) {
        OrderResponse response = orderService.createOrder(
            request.getCustomerId(), 
            request.getOrderItems()
        );
        return ResponseEntity.ok(response);
    }
    
    @Data
    private static class CreateOrderRequest {
        private Long customerId;
        private List<OrderItem> orderItems;
    }

}
