package com.appaces.ecommerce.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderItemsRequests(
        Integer id,
        Integer orderId,
        @NotNull(message = "Product is mandatory")
        Integer productId,
        @Positive(message = "quantity is mandatory")
        double quantity
) {
}
