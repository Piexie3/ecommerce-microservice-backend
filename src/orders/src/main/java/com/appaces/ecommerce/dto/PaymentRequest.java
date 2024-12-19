package com.appaces.ecommerce.dto;

import com.appaces.ecommerce.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        UserResponse user
) {
}
