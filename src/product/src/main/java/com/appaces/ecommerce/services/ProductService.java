package com.appaces.ecommerce.services;

import com.appaces.ecommerce.dto.ProductRequest;
import com.appaces.ecommerce.dto.ProductResponse;
import com.appaces.ecommerce.dto.PurchaseRequest;
import com.appaces.ecommerce.dto.PurchaseResponse;
import jakarta.validation.Valid;

import java.util.List;


public interface ProductService {

    Integer createProduct(@Valid ProductRequest request);
    List<PurchaseResponse> purchaseProduct(List<PurchaseRequest> request);
    ProductResponse findById(Integer id);
    List<ProductResponse> getAllProducts();
}


