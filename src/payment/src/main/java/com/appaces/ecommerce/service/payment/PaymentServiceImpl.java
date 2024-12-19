package com.appaces.ecommerce.service.payment;

import com.appaces.ecommerce.service.kafka.PaymentNotificationRequest;
import com.appaces.ecommerce.dto.PaymentRequest;
import com.appaces.ecommerce.repository.PaymentRepository;
import com.appaces.ecommerce.service.PaymentMapper;
import com.appaces.ecommerce.service.kafka.NotificationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository paymentRepository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;
    @Override
    public Integer createPayment(PaymentRequest request) {
        var payment = paymentRepository.save(mapper.toPayment(request));

        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.user().firstName(),
                        request.user().lastName(),
                        request.user().email()
                )
        );
        return payment.getId();
    }
}
