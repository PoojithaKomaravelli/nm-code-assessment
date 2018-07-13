package com.nm.cascade.web.category;
import com.nm.cascade.web.category.models.CategoryList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
	
	List<String> getCategories();

	CategoryList getSearchResultsForSelectedCategory(String category);


	void  saveData();
}
