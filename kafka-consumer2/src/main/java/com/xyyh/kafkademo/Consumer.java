package com.xyyh.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Consumer {

    @Autowired
    private MessageRepository repository;

    @KafkaListener(topics = {"test"})
    @Transactional
    public void test(List<String> messages) {
        List<Message> msgs = messages.stream().map(message -> {
            Message msg = new Message();
            msg.setMessage(message);
            return msg;
        }).collect(Collectors.toList());
        repository.saveAll(msgs);
        System.out.println("save message [" + messages.size() + "] 条 at" + ZonedDateTime.now().toString());
    }
}
