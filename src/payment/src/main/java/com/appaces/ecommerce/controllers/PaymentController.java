package com.appaces.ecommerce.controllers;

import com.appaces.ecommerce.dto.PaymentRequest;
import com.appaces.ecommerce.service.payment.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("${api.prefix}/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/pay")
    public ResponseEntity<Integer> createPayment(@RequestBody @Valid PaymentRequest request){
        return ResponseEntity.ok(paymentService.createPayment(request));
    }
}
