package io.github.axeld.report_service;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("k8s")
@EnableCaching
public class RedisConfig {
}