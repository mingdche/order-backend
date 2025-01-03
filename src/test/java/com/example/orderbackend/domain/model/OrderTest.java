package com.example.orderbackend.domain.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
public class OrderTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void testCreateOrder() {
        Member member = new Member();
        member.setName("John Doe");
        entityManager.persist(member);

        Subscription subscription = new Subscription();
        subscription.setType(SubscriptionType.MONTHLY);
        entityManager.persist(subscription);

        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setStatus(OrderStatus.PENDING);
        order.setMember(member);
        order.setSubscription(subscription);

        entityManager.persist(order);
        entityManager.flush();

        Order savedOrder = entityManager.find(Order.class, order.getId());
        assertThat(savedOrder).isNotNull();
        assertThat(savedOrder.getOrderDate()).isEqualTo(order.getOrderDate());
        assertThat(savedOrder.getStatus()).isEqualTo(order.getStatus());
        assertThat(savedOrder.getMember()).isEqualTo(member);
        assertThat(savedOrder.getSubscription()).isEqualTo(subscription);
    }

    @Test
    public void testOrderDateNotNull() {
        Order order = new Order();
        order.setStatus(OrderStatus.PENDING);

        
        entityManager.persist(order);
        entityManager.flush();
        
        assertThat(order.getOrderDate()).isNotNull();
    }

    @Test
    public void testOrderItemsRelationship() {
        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setStatus(OrderStatus.PENDING);
        entityManager.persist(order);

        MeetingService service1 = new MeetingService();
        service1.setName("Service 1");
        entityManager.persist(service1);

        MeetingService service2 = new MeetingService();
        service2.setName("Service 2");
        entityManager.persist(service2);

        OrderItem item1 = new OrderItem();
        item1.setMeetingService(service1);
        item1.setQuantity(2);
        item1.setOrder(order);
        entityManager.persist(item1);

        OrderItem item2 = new OrderItem();
        item2.setMeetingService(service2);
        item2.setQuantity(1);
        item2.setOrder(order);
        entityManager.persist(item2);

        entityManager.flush();
        entityManager.clear();

        Order retrievedOrder = entityManager.find(Order.class, order.getId());
        List<OrderItem> orderItems = retrievedOrder.getOrderItems();
        assertThat(orderItems).hasSize(2);
        assertThat(orderItems).extracting("meetingService.name").containsExactly("Service 1", "Service 2");
        assertThat(orderItems).extracting("quantity").containsExactly(2, 1);
    }
}
