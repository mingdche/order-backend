package com.example.orderbackend.application.dto;

import com.example.orderbackend.domain.model.MeetingService;
import com.example.orderbackend.domain.model.Order;
import com.example.orderbackend.domain.model.OrderItem;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderRequest {
    private Long memberId;
    private List<OrderItemRequest> orderItems;

    // Getters and setters
    public static Order toOrder(OrderRequest request) {
        Order order = new Order();
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemRequest itemDto : request.getOrderItems()) {
            OrderItem item = new OrderItem();
            MeetingService meetingService = new MeetingService();
            meetingService.setId(itemDto.getServiceId());
            item.setMeetingService(meetingService);
            item.setQuantity(itemDto.getQuantity());
            orderItems.add(item);
        }
        order.setOrderItems(orderItems);
        return order;
    }

    @Data
    public static class OrderItemRequest {
        private Long serviceId;
        private Integer quantity;
    }
}
