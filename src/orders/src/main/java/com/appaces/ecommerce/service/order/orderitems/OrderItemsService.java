package com.appaces.ecommerce.service.order.orderitems;

import com.appaces.ecommerce.dto.OrderItemResponse;
import com.appaces.ecommerce.dto.OrderItemsRequests;

import java.util.List;

public interface OrderItemsService {
    Integer saveOrderItems(OrderItemsRequests orderItemsRequests);

    List<OrderItemResponse> findByOrderId(Integer orderId);
}
