package com.appaces.ecommerce.kafka.payment;

import com.appaces.ecommerce.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentConfirmation(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String userName,
        String userLastName,
        String userEmail
) {
}
