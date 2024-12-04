package com.example.orderbackend.domain.repository;

import com.example.orderbackend.domain.model.Shipment;
import java.util.List;
import java.util.Optional;

public interface ShipmentRepository {
    Shipment save(Shipment shipment);
    Optional<Shipment> findById(Long id);
    List<Shipment> findAll();
    List<Shipment> findByOrderId(Long orderId);
    void deleteById(Long id);
}
