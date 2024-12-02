package com.appaces.ecommerce.service.order;

import com.appaces.ecommerce.dto.OrderRequest;
import jakarta.validation.Valid;

public interface OrderService {
    Integer createOrder(@Valid OrderRequest request);
}
