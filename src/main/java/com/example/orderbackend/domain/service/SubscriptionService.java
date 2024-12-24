package com.example.orderbackend.domain.service;

import com.example.orderbackend.domain.model.Subscription;
import com.example.orderbackend.domain.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }


    public Subscription getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id).orElse(null);
    }
}
