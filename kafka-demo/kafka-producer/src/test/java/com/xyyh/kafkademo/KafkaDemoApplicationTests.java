package com.xyyh.kafkademo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.ZonedDateTime;

@SpringBootTest
class KafkaDemoApplicationTests {


    @Autowired
    private KafkaTemplate template;

    @Test
    void contextLoads() {
    }

    @Test
    public void newMessage() {
        System.out.println("complete at " + ZonedDateTime.now() + "");
        for (int i = 0; i < 1000000; i++) {
            long now = System.currentTimeMillis();
            template.send("test", "adg" + now);
        }
    }
}
