package com.example.orderbackend.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class ConsumptionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "entitlement_id")
    private Entitlement entitlement;

    private Integer consumedDuration;
    private LocalDate consumptionDate;

    // Getters and setters
}
