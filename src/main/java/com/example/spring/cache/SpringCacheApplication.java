package com.example.spring.cache;

import hu.capsys.ms.common.redis.RedisConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackageClasses = RedisConfiguration.class,
        scanBasePackages = "com.example.spring.cache")
public class SpringCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCacheApplication.class, args);
    }

}
