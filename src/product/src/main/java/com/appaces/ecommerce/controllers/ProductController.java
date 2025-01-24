package com.appaces.ecommerce.controllers;

import com.appaces.ecommerce.dto.*;
import com.appaces.ecommerce.models.Category;
import com.appaces.ecommerce.services.category.CategoryService;
import com.appaces.ecommerce.services.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

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


    @PostMapping("/create-category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryRequest request){
        return ResponseEntity.ok(categoryService.createCategory(request));
    }

    @GetMapping("/get-all-categories")
    public ResponseEntity<List<Category>> getAllCategory(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }
}
