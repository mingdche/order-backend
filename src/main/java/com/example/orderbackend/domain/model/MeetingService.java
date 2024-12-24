package com.example.orderbackend.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class MeetingService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "meetingService")
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    // Getters and setters
}
