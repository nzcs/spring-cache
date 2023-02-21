package com.example.spring.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static com.example.spring.cache.CacheConfig.PAYEE_CACHE;

@Service
public class CacheService {

    @Autowired
    PayeeRepository repository;


    @Cacheable(value = PAYEE_CACHE, key = "{#id, #code}")
    public Payee get(String code, String id) {
        return repository.get(code, id);
    }


    @CachePut(value = PAYEE_CACHE, key = "{#id, #code}")
    public Payee put(String code, String id, Payee payee) {
        return payee;
    }


}
