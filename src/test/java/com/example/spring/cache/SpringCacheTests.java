package com.example.spring.cache;

import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static com.example.spring.cache.CacheConfig.PAYEE_CACHE;

@SpringBootTest
class SpringCacheTests {

    @Autowired
    CacheService cacheService;
    @Autowired
    private RedissonClient redisson;


    @Test
    void contextLoads() {
        cacheService.get("code_1", "pocs_1");
        cacheService.get("code_2", "pocs_1");
        cacheService.get("code_2", "pocs_2");

        System.out.println(cacheService.get("code_1", "pocs_1"));
        System.out.println(cacheService.get("code_2", "pocs_1"));
        System.out.println(cacheService.get("code_2", "pocs_2"));

        change("pocs_1", Payee.of("pocs_1", "name_2"));

        System.out.println(cacheService.get("code_1", "pocs_1"));
        System.out.println(cacheService.get("code_2", "pocs_1"));
        System.out.println(cacheService.get("code_2", "pocs_2"));
    }


    public void change(String id, Payee payee) {
        redisson.getKeys().getKeysStream()
                .filter(s -> s.contains(PAYEE_CACHE + "::" + id))
                .forEach(x -> {
                    String[] split = x.replaceFirst(PAYEE_CACHE + "::", "").split(",");
                    System.out.println(Arrays.toString(split));
                    cacheService.put(split[1], split[0], payee);
                });
    }

}
