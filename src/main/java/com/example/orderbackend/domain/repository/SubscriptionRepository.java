package com.example.orderbackend.domain.repository;

import java.util.Optional;

import com.example.orderbackend.domain.model.Subscription;

public interface SubscriptionRepository {

    Subscription save(Subscription subscription);

    Optional<Subscription> findById(Long id);
}
