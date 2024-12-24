package com.example.orderbackend.application.service;

import com.example.orderbackend.application.dto.OrderRequest;
import com.example.orderbackend.domain.model.Order;
import com.example.orderbackend.domain.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 这个是创建订单应用服务类
 * 用户一次性购买会议服务产生一个订单
 */
@Service
public class OrderPlacementService {

    private static final Logger logger = LoggerFactory.getLogger(OrderPlacementService.class);

    @Autowired
    private OrderService orderService;

    public Order placeOrder(OrderRequest request) {
        try {
            Order order = OrderRequest.toOrder(request);
            return orderService.createOrder(order);
        } catch (Exception e) {
            logger.error("Failed to place order: {}", request, e);
            throw new RuntimeException("Failed to place order", e);
        }
    }
}
