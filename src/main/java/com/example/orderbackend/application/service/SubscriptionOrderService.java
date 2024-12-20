package com.example.orderbackend.application.service;

import com.example.orderbackend.domain.model.Subscription;
import com.example.orderbackend.domain.service.SubscriptionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订阅是周期性产生订单的基础
 * 订阅的订单是自动付款的
 */
@Service
public class SubscriptionOrderService {
    
    private static final Logger logger = LoggerFactory.getLogger(SubscriptionOrderService.class);

    @Autowired
    private  SubscriptionService subscriptionService;

    @Transactional
    public Subscription createSubscriptionOrders(Subscription subscription) {
        subscription.createOrder();
        subscription = subscriptionService.createSubscription(subscription);
        return subscription;
    }

}
