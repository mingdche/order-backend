package com.example.orderbackend.infra.repository;

import com.example.orderbackend.domain.model.Shipment;
import com.example.orderbackend.domain.repository.ShipmentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ShipmentRepositoryImpl implements ShipmentRepository {

    private final ShipmentJpaRepository jpaRepository;

    public ShipmentRepositoryImpl(ShipmentJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Shipment save(Shipment shipment) {
        return jpaRepository.save(shipment);
    }

    @Override
    public Optional<Shipment> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Shipment> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public List<Shipment> findByOrderId(Long orderId) {
        return jpaRepository.findByOrderId(orderId);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}

interface ShipmentJpaRepository extends JpaRepository<Shipment, Long> {
    List<Shipment> findByOrderId(Long orderId);
}
