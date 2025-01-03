package com.example.orderbackend.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orderbackend.domain.model.Member;


@Repository
public interface MemberRepositoryJPAImpl extends JpaRepository<Member, Long> {

}
