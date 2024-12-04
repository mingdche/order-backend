package com.example.orderbackend.application.service;

import com.example.orderbackend.application.dto.OrderResponse;
import com.example.orderbackend.domain.model.Order;
import com.example.orderbackend.domain.model.Customer;
import com.example.orderbackend.domain.model.OrderItem;
import com.example.orderbackend.domain.repository.OrderRepository;
import com.example.orderbackend.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService { //AST

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public OrderResponse createOrder(Long customerId, List<OrderItem> orderItems) {
        Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        Order order = Order.create(customer, orderItems);
        Order savedOrder = orderRepository.save(order);
        return OrderResponse.fromOrder(savedOrder);
    }

    public OrderResponse getOrderById(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        return orderOptional.map(OrderResponse::fromOrder).orElse(null);
    }
}
