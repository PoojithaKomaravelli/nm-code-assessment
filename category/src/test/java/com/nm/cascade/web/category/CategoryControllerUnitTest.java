package com.nm.cascade.web.category;

import com.nm.cascade.web.category.models.CategoryList;
import com.nm.cascade.web.category.models.Entry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

/**
 * Created by PKomaravelli on 6/24/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerUnitTest {


    @InjectMocks
    private CategoryController controller;

    @Mock
    private CategoryService service;

    @Mock
    private List<String> categories;

    private static final String TEST_CATEGORY_NAME = "Animals";


    @Test
    public void testListCategories() throws Exception {

        when(service.getCategories()).thenReturn(categories);
        ResponseEntity result = (ResponseEntity) controller.getCategories();
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void testSearchResults() throws Exception {
        given(service.getSearchResultsForSelectedCategory(TEST_CATEGORY_NAME)).willReturn
                (CategoryList.builder().count(1).entries(
                        Arrays.asList(Entry.builder().api("Cat").build()))
                        .build());
        ResponseEntity<CategoryList> result = (ResponseEntity<CategoryList>) controller.getSearchResultsSelectedCategory(TEST_CATEGORY_NAME);
        assertThat(result.getStatusCode(), is(HttpStatus.OK));
        assertThat(result.getBody().getCount(), is(1));
    }
}
