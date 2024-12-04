package com.appaces.ecommerce.dto;

import com.appaces.ecommerce.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String reference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        UserResponse user,
        List<PurchaseResponse> products
) {
}
