package com.example.orderbackend.infra.repository;

import com.example.orderbackend.domain.model.Customer;
import com.example.orderbackend.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository jpaRepository;

    public CustomerRepositoryImpl(CustomerJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return jpaRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}

interface CustomerJpaRepository extends JpaRepository<Customer, Long> {}
