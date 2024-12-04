package com.example.orderbackend.domain.service;

import com.example.orderbackend.domain.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerDomainService {

    public Customer registerCustomer(Customer customer) {
        // 执行业务逻辑验证和处理
        // 例如:
        // 检查用户名是否已被使用
        // 加密密码
        // ...

        // 保存用户信息
        // ...

        return customer;
    }
}
