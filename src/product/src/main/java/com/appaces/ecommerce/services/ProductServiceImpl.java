package com.appaces.ecommerce.services;

import com.appaces.ecommerce.dto.*;
import com.appaces.ecommerce.models.Product;
import com.appaces.ecommerce.repository.ProductRepository;
import com.appaces.ecommerce.utils.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository repository;
    private final ProductMapper mapper;
    @Override
    public Integer createProduct(ProductRequest request) {
        Product product = mapper.toProduct(request);
        return repository.save(product).getId();
    }

    @Override
    public List<PurchaseResponse> purchaseProduct(List<PurchaseRequest> request) {
        return List.of();
    }

    @Override
    public ProductResponse findById(Integer id) {
        return repository.findById(id).map(
                mapper::toProductResponse
        ).orElseThrow(()->new CustomException("Product not found"));
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return repository.findAll()
                .stream()
                .map(mapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
