package com.xyyh.kafkademo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

//    @KafkaListener(topics = {"test"})
    public void test(String m) {
        System.out.println(m);
    }
}
