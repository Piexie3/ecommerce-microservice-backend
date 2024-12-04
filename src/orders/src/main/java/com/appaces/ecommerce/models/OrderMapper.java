package com.appaces.ecommerce.models;

import com.appaces.ecommerce.dto.OrderRequest;
import com.appaces.ecommerce.dto.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public Order toOrder(OrderRequest request) {
        return  Order.builder()
                .id(request.id())
                .userId(request.userId())
                .reference(request.reference())
                .totalAmount(request.amount())
                .paymentMethod(request.paymentMethod())
                .build();
    }

    public OrderResponse fromOrder(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getUserId()
        );
    }
}
