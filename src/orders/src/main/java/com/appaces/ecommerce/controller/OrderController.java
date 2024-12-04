package com.appaces.ecommerce.controller;

import com.appaces.ecommerce.dto.OrderRequest;
import com.appaces.ecommerce.dto.OrderResponse;
import com.appaces.ecommerce.service.order.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<Integer> createOrder(@RequestBody @Valid OrderRequest request){
        return ResponseEntity.ok(orderService.createOrder(request));
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderResponse>> findAllOrders(){
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/by-id/{orderId}")
    public ResponseEntity<OrderResponse> findById(@PathVariable Integer orderId){
        return ResponseEntity.ok(orderService.findById(orderId));
    }
}
