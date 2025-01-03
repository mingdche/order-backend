package com.example.orderbackend.domain.service;

import com.example.orderbackend.domain.model.Subscription;
import com.example.orderbackend.domain.repository.SubscriptionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SubscriptionServiceIntegrationTest {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Test
    void testCreateSubscription() {
        // 创建新订阅
        Subscription subscription = new Subscription();
        Subscription createdSubscription = subscriptionService.createSubscription(subscription);

        // 从数据库中查询订阅
        Optional<Subscription> foundSubscription = subscriptionRepository.findById(createdSubscription.getId());
        assertTrue(foundSubscription.isPresent());
        assertEquals(createdSubscription, foundSubscription.get());
    }
}
