package com.appaces.ecommerce.service.order.orderitems;

import com.appaces.ecommerce.dto.OrderItemsRequests;

public interface OrderItemsService {
    Integer saveOrderItems(OrderItemsRequests orderItemsRequests);
}
