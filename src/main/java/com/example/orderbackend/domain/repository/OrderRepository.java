package com.example.orderbackend.domain.repository;

import com.example.orderbackend.domain.model.Order;
import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(Long id);
    List<Order> findAll();
    List<Order> findByCustomerId(Long customerId);
    void deleteById(Long id);
}
