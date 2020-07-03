package com.xyyh.kafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@EnableKafka
public class KafkaConfig {

    /**
     * 新建一个主题
     *
     * @return
     */
    @Bean
    public NewTopic testTopic() {
        return TopicBuilder.name("test")// 指定主题名称
            .partitions(30) //指定分区数量
            .replicas(2) // 指定副本数量
            .compact()
            .build();
    }
}
