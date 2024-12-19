package com.appaces.ecommerce.service.kafka;

import com.appaces.ecommerce.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentNotificationRequest(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String userName,
        String userLastName,
        String userEmail
) {
}
