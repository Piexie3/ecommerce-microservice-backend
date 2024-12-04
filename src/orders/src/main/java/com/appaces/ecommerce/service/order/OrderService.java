package com.appaces.ecommerce.service.order;

import com.appaces.ecommerce.dto.OrderRequest;
import com.appaces.ecommerce.dto.OrderResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface OrderService {
    Integer createOrder(@Valid OrderRequest request);

    List<OrderResponse> findAll();

    OrderResponse findById(Integer orderId);
}
