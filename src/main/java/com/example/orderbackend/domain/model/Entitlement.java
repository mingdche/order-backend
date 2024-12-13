package com.example.orderbackend.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Entitlement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    @OneToOne
    @JoinColumn(name = "meeting_service_id")
    private MeetingService meetingService;

    private Integer duration;
    private Integer consumedDuration;

    // Getters and setters
}
