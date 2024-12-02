package com.appaces.ecommerce.dto;

import java.math.BigDecimal;

public record ProductResponse (
         String name,
         String description,
         double inventory,
         BigDecimal price,
         Integer categoryId,
         String categoryName
) {
}
