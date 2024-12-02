package com.appaces.ecommerce.services;

import com.appaces.ecommerce.dto.ProductRequest;
import com.appaces.ecommerce.dto.ProductResponse;
import com.appaces.ecommerce.dto.PurchaseResponse;
import com.appaces.ecommerce.models.Category;
import com.appaces.ecommerce.models.Product;
import jakarta.validation.constraints.NotNull;

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
        return null;
    }

    public PurchaseResponse toProductPurchaseResponse(Product product, @NotNull(message = "Quantity is mandatory") double quantity) {
        return new PurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}
