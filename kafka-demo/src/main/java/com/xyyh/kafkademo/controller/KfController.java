package com.xyyh.kafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("kf")
public class KfController {

    @Autowired
    private KafkaTemplate template;

    @GetMapping
    public String newMessage(WebRequest request) {
        for (int i = 0; i < 100000; i++) {
            long now = System.currentTimeMillis();
            template.send("test", "adg" + now);
        }
        return request.getSessionId() + "success";
    }
}
