package com.example.orderbackend.domain.service;

import com.example.orderbackend.domain.model.Order;
import com.example.orderbackend.domain.model.OrderItem;
import com.example.orderbackend.domain.model.Customer;
import com.example.orderbackend.domain.repository.OrderRepository;
import com.example.orderbackend.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public Order createOrder(Long customerId, List<OrderItem> orderItems) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + customerId));
        Order order = Order.create(customer, orderItems);
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public Order updateOrder(Long id, Order order) {
        return orderRepository.findById(id)
            .map(existingOrder -> {
                existingOrder.setCustomer(order.getCustomer());
                existingOrder.setOrderDate(order.getOrderDate()); // Change this line
                existingOrder.setStatus(order.getStatus());
                // Update other fields as necessary
                return orderRepository.save(existingOrder);
            })
            .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
