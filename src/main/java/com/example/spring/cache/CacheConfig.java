package com.example.spring.cache;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfig {

    public static final String PAYEE_CACHE = "payeeCache";


    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return (builder) -> builder
                .withCacheConfiguration(PAYEE_CACHE,
                        RedisCacheConfiguration.defaultCacheConfig()
                                .entryTtl(Duration.ofMillis(3000))
                );
    }


//    @Bean
//    public RedissonClient redisson() {
//        Config config = new Config();
//        config.useSingleServer()
//                .setAddress("redis://127.0.0.1:6379");
//        config.setNettyThreads(64);
//        return Redisson.create(config);
//    }

//    @Bean
//    public RedisConnectionFactory redisConnectionFactory(RedissonClient redisson) {
//        return new RedissonConnectionFactory(redisson);
//    }
}
