package com.example.orderbackend.domain.repository;

import com.example.orderbackend.domain.model.Order;

import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(Long id);
}
