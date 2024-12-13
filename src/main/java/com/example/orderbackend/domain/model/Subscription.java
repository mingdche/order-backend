package com.example.orderbackend.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SubscriptionType type;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany
    @JoinColumn(name = "meeting_service_id")
    private List<MeetingService> meetingServices;

    @OneToOne
    private Order order;

    public Order createOrder() {
        Order newOrder = new Order();
        newOrder.setMember(this.member);
        List<OrderItem> orderItems = new ArrayList<>();
        for (MeetingService meetingService : meetingServices) {
            OrderItem orderItem = new OrderItem();
            orderItem.setMeetingService(meetingService);
            orderItems.add(orderItem);
        }
        newOrder.setOrderItems(orderItems);
        this.order = newOrder;
        return newOrder;
    }
}
