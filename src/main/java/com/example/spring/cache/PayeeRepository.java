package com.example.spring.cache;

import org.springframework.stereotype.Service;

@Service
public class PayeeRepository {

    public Payee get(String code, String id) {
        System.out.println("PayeeRepository");
        return Payee.of(id, "name_1");
    }
}
