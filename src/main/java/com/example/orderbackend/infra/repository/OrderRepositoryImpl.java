package com.example.orderbackend.infra.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderbackend.domain.model.Order;
import com.example.orderbackend.domain.repository.OrderRepository;

@Service
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private OrderRepositoryJPAImpl orderRepositoryJPA;

    @Override
    public Order save(Order order) {
        return orderRepositoryJPA.save(order);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepositoryJPA.findById(id);
    }
    
}
