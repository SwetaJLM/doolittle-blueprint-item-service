package com.wn.doolittle.content.blueprintitem.service.config;

import java.time.Duration;

import com.wn.doolittle.content.cache.MultiGetContentPropertiesCacheClient;
import com.wn.doolittle.content.blueprintitem.service.model.BluePrintItemContentRepository;
import com.wn.doolittle.content.model.impl.DefaultContentProperties;
import com.wn.doolittle.content.model.impl.DefaultContentPropertiesRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import com.wn.doolittle.content.cache.MultiGetCacheClient;
import com.wn.doolittle.content.blueprintitem.service.model.entity.BluePrintItemContent;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

@Configuration
@EntityScan(basePackageClasses = {
        BluePrintItemContent.class,
        DefaultContentProperties.class
})
@EnableJpaRepositories(basePackageClasses = {
        BluePrintItemContentRepository.class,
        DefaultContentPropertiesRepository.class
})
public class BluePrintItemContentServiceConfig {

    @Bean
    public MultiGetCacheClient<BluePrintItemContent> bluePrintItemContentCacheClient(
            CircuitBreakerRegistry circuitBreakerRegistry,
            @Qualifier("doolittleRedisConnectionFactory") RedisConnectionFactory connectionFactory,
            @Value("${redis.contentcache.key.expiry:4h}") Duration keyExpiryDuration) {
        return new MultiGetCacheClient<>(
                circuitBreakerRegistry,
                connectionFactory,
                BluePrintItemContent.class,
                keyExpiryDuration);
    }

    @Bean
    public MultiGetContentPropertiesCacheClient<DefaultContentProperties> contentPropertiesCacheClient(
            CircuitBreakerRegistry circuitBreakerRegistry,
            @Qualifier("doolittleRedisConnectionFactory") RedisConnectionFactory connectionFactory,
            @Value("${redis.contentcache.key.expiry:4h}") Duration keyExpiryDuration) {
        return new MultiGetContentPropertiesCacheClient<>(
                circuitBreakerRegistry,
                connectionFactory,
                DefaultContentProperties.class,
                keyExpiryDuration);
    }

}
