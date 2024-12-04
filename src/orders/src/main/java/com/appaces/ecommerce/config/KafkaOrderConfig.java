package com.appaces.ecommerce.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaOrderConfig {

    @Bean
    public NewTopic orderTopic(){
        return TopicBuilder.name("Order-topic").build();
    }
}
