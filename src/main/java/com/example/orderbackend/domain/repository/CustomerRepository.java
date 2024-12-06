package com.example.orderbackend.domain.repository;

import com.example.orderbackend.domain.model.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<Customer> findById(Long id);
    List<Customer> findAll();
    void deleteById(Long id);
}
