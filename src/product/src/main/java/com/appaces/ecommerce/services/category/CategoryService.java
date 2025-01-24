package com.appaces.ecommerce.services.category;

import com.appaces.ecommerce.dto.CategoryRequest;
import com.appaces.ecommerce.dto.CategoryResponse;
import com.appaces.ecommerce.models.Category;

import java.util.List;

public interface  CategoryService {
    Category createCategory(CategoryRequest request);

    List<Category> getAllCategory();
}
