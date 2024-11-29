package com.appaces.ecommerce.services;

import com.appaces.ecommerce.dto.ProductRequest;
import com.appaces.ecommerce.dto.ProductResponse;
import com.appaces.ecommerce.models.Category;
import com.appaces.ecommerce.models.Product;

public class ProductMapper {
    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .inventory(request.inventory())
                .price(request.price())
                .category(Category.builder().id(request.categoryId()).build())
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getName(),
                product.getDescription(),
                product.getInventory(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getCategory().getName()
        );
    }
}
