package com.appaces.ecommerce.service.kafka;

import com.appaces.ecommerce.enums.EmailTemplates;
import com.appaces.ecommerce.enums.NotificationType;
import com.appaces.ecommerce.kafka.order.OrderConfirmation;
import com.appaces.ecommerce.kafka.payment.PaymentConfirmation;
import com.appaces.ecommerce.models.Notification;
import com.appaces.ecommerce.repository.NotificationRepository;
import com.appaces.ecommerce.service.email.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.appaces.ecommerce.enums.NotificationType.PAYMENT_CONFIRMATION;
import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationConsumer {
    private final NotificationRepository repository;
    private final EmailService emailService;


    @KafkaListener(topics = "payment-topic")
    public void successPaymentNotification(PaymentConfirmation request) throws MessagingException {
//        log.info("Consuming the message from payment-topic: %s", request);
        repository.save(
                Notification.builder()
                        .notificationType(PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(request)
                        .build()
        );
        var username = request.userName() + " "+request.userLastName();

        emailService.sendPaymentSuccessEmail(
                request.userEmail(),
                username,
                request.amount(),
                request.orderReference()
        );

    }

    @KafkaListener(topics = "order-topic")
    public void successOrderNotification(OrderConfirmation request) throws MessagingException {
        log.info("Consuming the message from order-topic: {}", request);
        repository.save(
                Notification.builder()
                        .notificationType(PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .orderConfirmation(request)
                        .build()
        );
        var username = request.user().firstName() + " "+request.user().lastName();

        emailService.sendOrderSuccessEmail(
                request.user().email(),
                username,
                request.amount(),
                request.orderReference(),
                request.product()
        );

    }
}
