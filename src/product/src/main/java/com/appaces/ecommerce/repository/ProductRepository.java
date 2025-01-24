package com.appaces.ecommerce.repository;

import com.appaces.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllProductsByIdIn(List<Integer> productIds);
}
