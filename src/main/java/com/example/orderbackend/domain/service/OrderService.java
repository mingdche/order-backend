package com.example.orderbackend.domain.service;

import com.example.orderbackend.domain.model.Order;
import com.example.orderbackend.domain.model.OrderItem;
import com.example.orderbackend.domain.model.Member;
import com.example.orderbackend.domain.model.OrderStatus;
import com.example.orderbackend.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

}
