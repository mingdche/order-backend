package com.example.orderbackend.api;

import com.example.orderbackend.application.dto.OrderRequest;
import com.example.orderbackend.application.service.OrderPlacementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderResources {

    private static final Logger logger = LoggerFactory.getLogger(OrderResources.class);

    @Autowired
    private OrderPlacementService orderPlacementService;

    
    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest request) {
        try {
            orderPlacementService.placeOrder(request);
            return ResponseEntity.ok("Order placed successfully");
        } catch (Exception e) {
            logger.error("Failed to place order: {}", request, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to place order");
        }
    }
}
