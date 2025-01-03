package com.example.orderbackend.domain.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class SubscriptionTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void testCreateSubscription() {
        Member member = new Member();
        member.setName("John Doe");
        entityManager.persist(member);

        MeetingService service1 = new MeetingService();
        service1.setName("Service 1");
        entityManager.persist(service1);

        MeetingService service2 = new MeetingService();
        service2.setName("Service 2");
        entityManager.persist(service2);

        Subscription subscription = new Subscription();
        subscription.setType(SubscriptionType.MONTHLY);
        subscription.setMember(member);
        subscription.setStartDate(LocalDate.now());
        subscription.setEndDate(LocalDate.now().plusMonths(1));
        subscription.getMeetingServices().add(service1);
        subscription.getMeetingServices().add(service2);

        entityManager.persist(subscription);
        entityManager.flush();

        Subscription savedSubscription = entityManager.find(Subscription.class, subscription.getId());
        assertThat(savedSubscription).isNotNull();
        assertThat(savedSubscription.getType()).isEqualTo(subscription.getType());
        assertThat(savedSubscription.getMember()).isEqualTo(member);
        assertThat(savedSubscription.getStartDate()).isEqualTo(subscription.getStartDate());
        assertThat(savedSubscription.getEndDate()).isEqualTo(subscription.getEndDate());
        assertThat(savedSubscription.getMeetingServices()).containsExactly(service1, service2);
    }

    @Test
    public void testCreateOrder() {
        Member member = new Member();
        member.setName("John Doe");
        entityManager.persist(member);

        MeetingService service1 = new MeetingService();
        service1.setName("Service 1");
        entityManager.persist(service1);

        MeetingService service2 = new MeetingService();
        service2.setName("Service 2");
        entityManager.persist(service2);

        Subscription subscription = new Subscription();
        subscription.setType(SubscriptionType.MONTHLY);
        subscription.setMember(member);
        subscription.setStartDate(LocalDate.now());
        subscription.setEndDate(LocalDate.now().plusMonths(1));
        subscription.getMeetingServices().add(service1);
        subscription.getMeetingServices().add(service2);
        entityManager.persist(subscription);

        Order order = subscription.createOrder();
        entityManager.persist(order);
        entityManager.flush();

        Order savedOrder = entityManager.find(Order.class, order.getId());
        assertThat(savedOrder).isNotNull();
        assertThat(savedOrder.getOrderDate()).isEqualTo(LocalDate.now());
        assertThat(savedOrder.getStatus()).isEqualTo(OrderStatus.PENDING);
        assertThat(savedOrder.getMember()).isEqualTo(member);
        assertThat(savedOrder.getSubscription()).isEqualTo(subscription);
        assertThat(savedOrder.getOrderItems()).hasSize(2);
        assertThat(savedOrder.getOrderItems()).extracting("meetingService.name").containsExactly("Service 1", "Service 2");
    }
}
