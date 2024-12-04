package com.example.orderbackend.application.service;

import com.example.orderbackend.domain.model.Customer;
import com.example.orderbackend.domain.service.CustomerDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerApplicationService {
    @Autowired
    private CustomerDomainService customerDomainService;

    public Customer registerCustomer(Customer customer) {
        return customerDomainService.registerCustomer(customer);
    }
}
