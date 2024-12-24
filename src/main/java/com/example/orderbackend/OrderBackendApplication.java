package com.example.orderbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 这个是整个应用程序的入口
 */
@SpringBootApplication
public class OrderBackendApplication {

    /**
     * Springboot的入口
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(OrderBackendApplication.class, args);
    }

}
