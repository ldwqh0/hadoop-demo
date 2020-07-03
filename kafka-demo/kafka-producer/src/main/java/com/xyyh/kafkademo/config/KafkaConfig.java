package com.xyyh.kafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@EnableKafka
public class KafkaConfig {

    @Bean
    public NewTopic testTopic() {
        return TopicBuilder.name("test")
            .partitions(30)
            .replicas(1)
            .compact()
            .build();
    }
}
