package com.appaces.ecommerce.services.category;

import com.appaces.ecommerce.dto.CategoryResponse;
import com.appaces.ecommerce.models.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {
    public CategoryResponse toCategory(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
