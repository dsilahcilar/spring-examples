package com.saha.configuration;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfiguration {

  //  @Bean
    public CacheManager firtCacheManager() {
        GuavaCacheManager cacheManager = new GuavaCacheManager();

        CacheBuilder<Object, Object> cb = CacheBuilder.newBuilder()
                .expireAfterWrite(10, TimeUnit.SECONDS);

        cacheManager.setCacheBuilder(cb);

        return cacheManager;
    }


    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();


        CacheBuilder<Object, Object> cb = CacheBuilder.newBuilder()
                .expireAfterWrite(10, TimeUnit.SECONDS);
        GuavaCache userCache = new GuavaCache("users", cb.build());

        CacheBuilder<Object, Object> cb2 = CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.SECONDS);
        GuavaCache usersCache = new GuavaCache("allusers", cb2.build());

        simpleCacheManager.setCaches(Arrays.asList(userCache, usersCache));

        return simpleCacheManager;
    }

}
