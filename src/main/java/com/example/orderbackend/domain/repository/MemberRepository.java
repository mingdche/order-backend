package com.example.orderbackend.domain.repository;

import org.springframework.stereotype.Repository;

import com.example.orderbackend.domain.model.Member;

public interface MemberRepository {
    Member findById(Long id);
}
