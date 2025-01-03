package com.example.orderbackend.domain.service;

import com.example.orderbackend.domain.model.Member;
import com.example.orderbackend.domain.model.Order;
import com.example.orderbackend.domain.model.OrderStatus;
import com.example.orderbackend.domain.repository.MemberRepository;
import com.example.orderbackend.domain.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class OrderServiceIntegrationTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void testCreateOrder() {
        // 创建会员
        Member member = new Member();
        member.setName("John Doe");
        member = memberRepository.save(member);

        // 创建新订单
        Order order = new Order();
        order.setMember(member);
        Order createdOrder = orderService.createOrder(order);

        // 验证订单状态和创建日期
        assertEquals(OrderStatus.PENDING, createdOrder.getStatus());
        assertEquals(LocalDate.now(), createdOrder.getOrderDate());

        // 从数据库中查询订单
        Optional<Order> foundOrder = orderRepository.findById(createdOrder.getId());
        assertTrue(foundOrder.isPresent());
    }
}
