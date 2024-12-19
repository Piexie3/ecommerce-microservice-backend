package com.appaces.ecommerce.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<PaymentRepository,String> {
}
