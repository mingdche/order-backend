package com.example.orderbackend.domain.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.orderbackend.domain.model.Subscription;

@Repository
public interface SubscriptionRepository {

    Subscription save(Subscription subscription);

    void deleteById(Long id);

    Optional<Subscription> findById(Long id);
}
