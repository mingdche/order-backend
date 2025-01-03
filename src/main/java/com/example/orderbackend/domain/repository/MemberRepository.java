package com.example.orderbackend.domain.repository;


import java.util.Optional;

import com.example.orderbackend.domain.model.Member;

public interface MemberRepository {
    Optional<Member> findById(Long id);
    Member save(Member member);
}
