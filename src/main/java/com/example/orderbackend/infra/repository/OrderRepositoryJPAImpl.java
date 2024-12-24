package com.example.orderbackend.infra.repository;

import com.example.orderbackend.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryJPAImpl extends JpaRepository<Order, Long> {
    // 可以在这里添加自定义查询方法
}
