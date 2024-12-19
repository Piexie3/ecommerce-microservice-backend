package com.appaces.ecommerce.kafka.order;

import com.appaces.ecommerce.dto.Product;
import com.appaces.ecommerce.dto.UserResponse;
import com.appaces.ecommerce.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        UserResponse user,
        List<Product> product
) {
}
