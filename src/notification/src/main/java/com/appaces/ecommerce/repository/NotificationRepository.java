package com.appaces.ecommerce.repository;

import com.appaces.ecommerce.models.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification,String> {
}
