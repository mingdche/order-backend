package com.example.orderbackend.domain.service;

import com.example.orderbackend.domain.model.Order;
import com.example.orderbackend.domain.model.OrderItem;
import com.example.orderbackend.domain.model.Member;
import com.example.orderbackend.domain.model.OrderStatus;
import com.example.orderbackend.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * 订单管理服务类
 * 1. 用于协调多个订单之间的协作
 * 2. 管理订单的生命周期
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    /**
     * 创建新订单
     *
     * @param memberId 会员ID
     * @param orderItems 订单项列表
     * @return 新创建的订单
     */
    public Order createOrder(Long memberId, List<OrderItem> orderItems) {
        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setStatus(OrderStatus.PENDING);

        // 设置会员信息
        Member member = new Member();
        member.setId(memberId);
        order.setMember(member);

        // 设置订单项
        order.setOrderItems(orderItems);

        return orderRepository.save(order);
    }

    /**
     * 根据订单ID查询订单
     *
     * @param orderId 订单ID
     * @return 订单对象
     */
    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    /**
     * 根据会员ID查询订单列表
     *
     * @param memberId 会员ID
     * @return 订单列表
     */
    public List<Order> getOrdersByMemberId(Long memberId) {
        return orderRepository.findByMemberId(memberId);
    }

    /**
     * 更新订单
     *
     * @param order 更新后的订单对象
     * @return 更新后的订单对象
     */
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    /**
     * 删除订单
     *
     * @param orderId 订单ID
     */
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
