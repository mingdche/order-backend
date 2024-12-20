package com.example.orderbackend.domain.repository;

import com.example.orderbackend.domain.model.MeetingService;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingServiceRepository {
    MeetingService save(MeetingService product);
    Optional<MeetingService> findById(Long id);
    List<MeetingService> findAll();
    void deleteById(Long id);
}
