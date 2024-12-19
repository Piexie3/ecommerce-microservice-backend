package com.appaces.ecommerce.service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String,OrderConfirmation> kafkaTemplate;

    public void sendOrderConfirmation(OrderConfirmation request){
        log.info("sending order confirmation");
        Message<OrderConfirmation> message = MessageBuilder
                .withPayload(request)
                .setHeader(KafkaHeaders.TOPIC,"order-topic")
                .build();
        kafkaTemplate.send(message);
    }
}
