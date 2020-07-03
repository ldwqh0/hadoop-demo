package com.xyyh.kafkademo;

import com.xyyh.kafkademo.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
