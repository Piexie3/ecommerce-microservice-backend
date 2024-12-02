package com.appaces.ecommerce.repository;

import com.appaces.ecommerce.models.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItems,Integer> {
}
