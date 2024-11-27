package com.appaces.ecommerce.repository;

import com.appaces.ecommerce.customer.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
