package com.appaces.ecommerce.repository;

import com.appaces.ecommerce.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
