package com.nm.cascade.web.category;

import com.nm.cascade.web.category.models.CategoryList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value="/api")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
@Api
public class CategoryController {


 private CategoryService service;

    @ApiOperation(value = "List available categories")
    @RequestMapping(method = RequestMethod.GET, path = "/categories")
    public HttpEntity<?> getCategories() {
        List<String> categories = service.getCategories();

        return new ResponseEntity<List<String>>(categories, HttpStatus.OK);
    }

    @ApiOperation(value = "List search results by Category Name")
    @RequestMapping(method = RequestMethod.GET, path = "/entries")
    public HttpEntity<?> getSearchResultsSelectedCategory(@RequestParam(name = "category", required = true) String category) {
        CategoryList categoryExamples = service.getSearchResultsForSelectedCategory(category);

        return new ResponseEntity<CategoryList>(categoryExamples, HttpStatus.OK);
    }

}
