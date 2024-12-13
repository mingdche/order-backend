package com.example.orderbackend.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Getters and setters
}
