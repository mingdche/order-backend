package com.example.orderbackend.application.dto;

import com.example.orderbackend.domain.model.Order;
import com.example.orderbackend.domain.model.OrderItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

@Data
public class OrderResponse {
    private Long id;
    private Long customerId;
    private List<Long> orderItemIds;
    private BigDecimal totalAmount;
    private String status;

    public static OrderResponse fromOrder(Order order) {
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setCustomerId(order.getCustomer().getId());
        response.setOrderItemIds(order.getOrderItems().stream()
                .map(OrderItem::getId)
                .collect(Collectors.toList()));
        response.setTotalAmount(new BigDecimal(calculateTotalAmount(order)));
        response.setStatus(order.getStatus().name());
        return response;
    }

    private static double calculateTotalAmount(Order order) {
        return order.getOrderItems().stream()
                .mapToDouble(OrderItem::getPrice)
                .sum();
    }
}
