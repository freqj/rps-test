package io.github.axeld.report_service;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
@Profile("k8s")
@EnableCaching
public class RedisConfig {
    @Bean
public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
    RedisCacheConfiguration config = RedisCacheConfiguration
        .defaultCacheConfig()
        .serializeValuesWith(
                RedisSerializationContext.SerializationPair
                        .fromSerializer(RedisSerializer.json())
        );
    return RedisCacheManager.builder(connectionFactory)
            .cacheDefaults(config)
            .build();
}
}