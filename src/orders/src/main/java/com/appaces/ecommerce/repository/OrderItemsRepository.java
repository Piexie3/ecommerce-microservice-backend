package com.appaces.ecommerce.repository;

import com.appaces.ecommerce.dto.OrderItemResponse;
import com.appaces.ecommerce.models.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemsRepository extends JpaRepository<OrderItems,Integer> {
    List<OrderItems> findAllByOrderId(Integer orderId);
}
