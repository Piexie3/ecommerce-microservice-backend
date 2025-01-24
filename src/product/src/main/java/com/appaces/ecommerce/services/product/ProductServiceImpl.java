package com.appaces.ecommerce.services.product;

import com.appaces.ecommerce.dto.*;
import com.appaces.ecommerce.models.Product;
import com.appaces.ecommerce.repository.ProductRepository;
import com.appaces.ecommerce.utils.exceptions.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
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
        List<Integer> productIds = request.stream()
                .map(PurchaseRequest::productId)
                .toList();
        var products = repository.findAllProductsByIdIn(productIds);
        if (productIds.size() != products.size()){
            throw new CustomException("One or more products doesn't exists");
        }
        var storeRequest = request
                .stream()
                .sorted(Comparator.comparing(PurchaseRequest::productId))
                .toList();
        var purchasedProducts = new ArrayList<PurchaseResponse>();
        for(int i = 0;i<storeRequest.size();i++){
            var product = products.get(i);
            var productRequest= storeRequest.get(i);
            if (product.getInventory()<productRequest.quantity()){
                throw new CustomException("Oops, We have Insufficient quantity in stock. Try again later");
            }
            var newAvailableQuantity = product.getInventory() - productRequest.quantity();
            product.setInventory(newAvailableQuantity);
            repository.save(product);
            purchasedProducts.add(mapper.toProductPurchaseResponse(product,productRequest.quantity()));
        }
        return purchasedProducts;
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
