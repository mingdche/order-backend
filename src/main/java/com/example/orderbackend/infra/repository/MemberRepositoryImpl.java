package com.example.orderbackend.infra.repository;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderbackend.domain.model.Member;
import com.example.orderbackend.domain.repository.MemberRepository;

@Service
public class MemberRepositoryImpl implements MemberRepository {

    @Autowired
    private MemberRepositoryJPAImpl memberRepositoryJPA;

    @Override
    public Optional<Member> findById(Long id) {
        return memberRepositoryJPA.findById(id);
    }

    @Override
    public Member save(Member member) {
        return memberRepositoryJPA.save(member);
    }
}
