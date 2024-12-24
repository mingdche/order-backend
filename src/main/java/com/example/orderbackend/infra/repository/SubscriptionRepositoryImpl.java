package com.example.orderbackend.infra.repository;

import com.example.orderbackend.domain.model.Subscription;
import com.example.orderbackend.domain.repository.SubscriptionRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SubscriptionRepositoryImpl implements SubscriptionRepository {

    @Autowired
    private SubscriptionRepositoryJPAImpl subscriptionRepositoryJPA;

    @Override
    public Subscription save(Subscription subscription) {
        return subscriptionRepositoryJPA.save(subscription);
    }

   
    @Override
    public Optional<Subscription> findById(Long id) {
        return subscriptionRepositoryJPA.findById(id);
    }
    
}
