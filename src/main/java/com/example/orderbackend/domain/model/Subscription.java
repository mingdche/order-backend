package com.example.orderbackend.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * 订阅代表对一些会议服务的周期性购买
 * 
 * 目前订阅有两种形式，一种是按月订阅，一种是按时间区间
 * 
 * 按月的订阅根据开始日期，每个月进行订单生成，
 *      例如开始时间是某个月份的第一天，那么它会在每个月的第一天生成订单并自动支付
 * 按时间区间的订阅只生成一个订单，用户支付订单后订阅生效，用户可以在订阅开始日期之后，结束日期之前使用订阅的服务
 *      例如开始时间是某个月份的第一天，结束时间是某个月份的最后一天，那么它只会在开始日期生成订单并自动支付，结束日期之前用户可以使用订阅的服务
 *      
 * 
 */
@Entity
@Table(name = "subscriptions")
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

    private LocalDate startDate;

    private LocalDate endDate;

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    /**
     * 从订阅中创建订单
     * @return
     */
    public Order createOrder() {
        Order newOrder = new Order();
        newOrder.setOrderDate(LocalDate.now());
        newOrder.setStatus(OrderStatus.PENDING);
        newOrder.setMember(this.member);
        List<OrderItem> orderItems = new ArrayList<>();
        for (MeetingService meetingService : meetingServices) {
            OrderItem orderItem = new OrderItem();
            orderItem.setMeetingService(meetingService);
            orderItems.add(orderItem);
        }
        newOrder.setOrderItems(orderItems);
        newOrder.setSubscription(this);
        orders.add(newOrder);
        return newOrder;
    }
}
