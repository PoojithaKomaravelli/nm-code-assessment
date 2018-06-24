package com.nm.cascade.web.category;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by PKomaravelli on 6/24/2018.
 */
@Configuration
public class CategoryConfiguration {

    @Bean
    public CategoryService categoryService() {
        return new CategoryServiceImpl();
    }
}
