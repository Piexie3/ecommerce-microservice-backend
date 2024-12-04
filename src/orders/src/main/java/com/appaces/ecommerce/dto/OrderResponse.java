package com.appaces.ecommerce.dto;

import com.appaces.ecommerce.enums.PaymentMethod;

import java.math.BigDecimal;

public record OrderResponse(
        Integer id,
        String reference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String userId

) {
}
