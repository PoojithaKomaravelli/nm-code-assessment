package com.nm.cascade.web.category;

import com.nm.cascade.web.category.models.CategoryList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class CategoryServiceImpl  implements CategoryService{

    @Value("${nwm.base-url}")
    private String baseUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Cacheable(cacheNames = "categories", unless = "#result == null")
    @Override
    public List<String> getCategories() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("categories");
        ResponseEntity<String[]> responseEntity= restTemplate.getForEntity(uriBuilder.build().encode().toUri(), String[].class);
        return Arrays.asList(responseEntity.getBody());
    }

    @Cacheable(cacheNames = "searchResults", key = "#category", unless = "#result == null")
    @Override
    public CategoryList getSearchResultsForSelectedCategory(String category) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("entries")
                .queryParam("category", category);
        RequestEntity<Void> requestEntity = RequestEntity
                .get(uriBuilder.build().encode().toUri())
                .build();
        ResponseEntity<CategoryList> searchResults  = restTemplate.exchange(requestEntity,CategoryList.class);
        return searchResults.getBody();
    }
}
