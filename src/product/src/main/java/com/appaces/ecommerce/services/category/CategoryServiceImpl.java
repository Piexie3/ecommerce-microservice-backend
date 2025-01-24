package com.appaces.ecommerce.services.category;

import com.appaces.ecommerce.dto.CategoryRequest;
import com.appaces.ecommerce.dto.CategoryResponse;
import com.appaces.ecommerce.models.Category;
import com.appaces.ecommerce.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository repository;
    private final CategoryMapper mapper;
    @Override
    public Category createCategory(CategoryRequest request) {
        Category category =  Category.builder()
                .name(request.getName())
                .build();
//        CategoryResponse response = mapper.toCategory(category);

        return repository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return repository.findAll().stream().toList();
    }
}
