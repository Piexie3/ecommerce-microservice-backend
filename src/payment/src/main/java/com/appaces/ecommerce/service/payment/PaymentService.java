package com.appaces.ecommerce.service.payment;

import com.appaces.ecommerce.dto.PaymentRequest;
import jakarta.validation.Valid;

public interface PaymentService {
    Integer createPayment(@Valid PaymentRequest request);
}
