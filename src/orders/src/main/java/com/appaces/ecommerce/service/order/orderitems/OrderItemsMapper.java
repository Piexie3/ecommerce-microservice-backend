package com.appaces.ecommerce.service.order.orderitems;

import com.appaces.ecommerce.dto.OrderItemsRequests;
import com.appaces.ecommerce.models.Order;
import com.appaces.ecommerce.models.OrderItems;
import org.springframework.stereotype.Service;

@Service
public class OrderItemsMapper {
    public OrderItems toOrderItems(OrderItemsRequests requests) {
        return OrderItems.builder()
                .id(requests.id())
                .quantity(requests.quantity())
                .order(Order.builder()
                        .id(requests.orderId())
                        .build()
                 )
                .productId(requests.productId())
                .build();
    }
}
