package com.example.orderbackend.api;

import com.example.orderbackend.domain.model.Customer;
import com.example.orderbackend.domain.service.CustomerDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerResources {
    @Autowired
    private CustomerDomainService customerDomainService;

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        Customer registeredCustomer = customerDomainService.registerCustomer(customer);
        return new ResponseEntity<>(registeredCustomer, HttpStatus.CREATED);
    }
}
