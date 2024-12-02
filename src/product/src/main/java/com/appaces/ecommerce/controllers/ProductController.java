package com.appaces.ecommerce.controllers;

import com.appaces.ecommerce.dto.ProductRequest;
import com.appaces.ecommerce.dto.ProductResponse;
import com.appaces.ecommerce.dto.PurchaseRequest;
import com.appaces.ecommerce.dto.PurchaseResponse;
import com.appaces.ecommerce.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/products")
@RequiredArgsConstructor
public class ProductController {
    private ProductService productService;

    @PostMapping("/upload-product")
    public ResponseEntity<Integer> createProduct(@RequestBody @Valid ProductRequest request){
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<PurchaseResponse>> purchaseProduct(@RequestBody List<PurchaseRequest> request){
        return ResponseEntity.ok(productService.purchaseProduct(request));
    }

    @GetMapping("/get-by-Id/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Integer id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> allProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

}
