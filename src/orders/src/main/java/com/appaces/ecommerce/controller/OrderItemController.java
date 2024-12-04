package com.appaces.ecommerce.controller;

import com.appaces.ecommerce.dto.OrderItemResponse;
import com.appaces.ecommerce.service.order.orderitems.OrderItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/orders-items")
@RequiredArgsConstructor
public class OrderItemController {
    private final OrderItemsService service;

    @GetMapping("/by-order-id/{orderId}")
    public ResponseEntity<List<OrderItemResponse>> findByOrderId(@PathVariable Integer orderId){
        return ResponseEntity.ok(service.findByOrderId(orderId));
    }
}
