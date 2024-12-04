package com.example.orderbackend.domain.service;

import com.example.orderbackend.domain.model.Shipment;
import com.example.orderbackend.domain.repository.ShipmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    public Optional<Shipment> getShipmentById(Long id) {
        return shipmentRepository.findById(id);
    }

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    public List<Shipment> getShipmentsByOrderId(Long orderId) {
        return shipmentRepository.findByOrderId(orderId);
    }

    public Shipment updateShipment(Long id, Shipment shipment) {
        return shipmentRepository.findById(id)
            .map(existingShipment -> {
                existingShipment.setOrder(shipment.getOrder());
                existingShipment.setShipDate(shipment.getShipDate());
                existingShipment.setStatus(shipment.getStatus());
                // Update other fields as necessary
                return shipmentRepository.save(existingShipment);
            })
            .orElseThrow(() -> new RuntimeException("Shipment not found with id " + id));
    }

    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }
}
