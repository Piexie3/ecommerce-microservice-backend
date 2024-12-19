package com.appaces.ecommerce.service;

import com.appaces.ecommerce.dto.PaymentRequest;
import com.appaces.ecommerce.models.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {
    public Payment toPayment(PaymentRequest request) {
        return Payment.builder()
                .id(request.id())
                .paymentMethod(request.paymentMethod())
                .amount(request.amount())
                .orderId(request.orderId())
                .build();
    }
}
