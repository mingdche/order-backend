package com.example.orderbackend.domain.repository;

import com.example.orderbackend.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    List<Order> findByMemberId(Long memberId);
    void deleteById(Long id);
    Optional<Order> findById(Long id);
}
