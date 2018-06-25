package com.nm.cascade.web.category;


import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PKomaravelli on 6/24/2018.
 */
@Configuration
public class CategoryConfiguration {

    @Bean
    public CategoryService categoryService() {
        return new CategoryServiceImpl();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<Cache> caches = new ArrayList<>(2);
        caches.add(new ConcurrentMapCache("categories"));
        caches.add(new ConcurrentMapCache("searchResults"));
        cacheManager.setCaches(caches);
        return cacheManager;
    }
}
