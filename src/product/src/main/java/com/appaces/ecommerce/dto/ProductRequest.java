package com.appaces.ecommerce.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,
        @NotNull(message = "Product name is required")
        String name,
        @NotNull(message = "Product description is required")
        String description,
        @Positive(message = "Available quantity should be positive")
        int inventory,
        @Positive(message = "price should be positive")
        BigDecimal price,
        @NotNull(message = "product category is required")
        Integer categoryId

) {

}
