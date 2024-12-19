package com.appaces.ecommerce.models;

import com.appaces.ecommerce.enums.NotificationType;
import com.appaces.ecommerce.kafka.order.OrderConfirmation;
import com.appaces.ecommerce.kafka.payment.PaymentConfirmation;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@Document
public class Notification {
    @Id
    private String id;

    private NotificationType notificationType;

    private OrderConfirmation orderConfirmation;

    private PaymentConfirmation paymentConfirmation;

    private LocalDateTime notificationDate;
}
