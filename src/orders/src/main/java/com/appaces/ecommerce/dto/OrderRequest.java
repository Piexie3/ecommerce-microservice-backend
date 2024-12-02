package com.appaces.ecommerce.dto;

import com.appaces.ecommerce.enums.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest (
    Integer id,
    String reference,
    @Positive(message = "Order amount should be positive")
    BigDecimal amount,
    @NotNull(message = "Payment method should be precised")
    PaymentMethod paymentMethod,
    @NotNull(message = "user should be present")
    @NotEmpty(message = "user should be present")
    @NotBlank(message = "user should be present")
    String userId,
    @NotEmpty(message = "You should purchase one product")
    List<PurchaseRequest> products
){
}
