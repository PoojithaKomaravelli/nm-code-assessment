package com.nm.cascade.web.category;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CategoryApplication {

	public static void main(String[] args) {

		SpringApplication.run(CategoryApplication.class, args);
	}
}
