package com.example.orderbackend.domain.service;

import com.example.orderbackend.domain.model.Customer;
import com.example.orderbackend.domain.repository.CustomerRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class CustomerDomainServiceTest {

    @InjectMocks
    private CustomerDomainService customerDomainService;

    @Mock
    private CustomerRepository customerRepository; // 模拟依赖项

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterCustomer_Success() {
        // 准备测试数据
        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setEmail("john@example.com");
        customer.setAddress("123 Main St");
        customer.setUsername("johndoe");
        customer.setPassword("password");

        // 模拟存储库行为
        when(customerRepository.save(customer)).thenReturn(customer);

        // 执行测试
        Customer registeredCustomer = customerDomainService.registerCustomer(customer);

        // 验证结果
        assertNotNull(registeredCustomer);
        assertEquals("John Doe", registeredCustomer.getName());
        assertEquals("john@example.com", registeredCustomer.getEmail());
        assertEquals("123 Main St", registeredCustomer.getAddress());
        assertEquals("johndoe", registeredCustomer.getUsername());
        // 密码应该被加密
        assertNotEquals("password", registeredCustomer.getPassword());
    }

    // 添加更多测试用例...
}
