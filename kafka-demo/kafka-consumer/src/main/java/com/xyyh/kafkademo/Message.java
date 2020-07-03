package com.xyyh.kafkademo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "message_")
@Getter
@Setter
public class Message implements Persistable<Long> {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message_")
    private String message;

    public Message() {

    }

    public Message(String message) {
        this.message = message;
    }

    @Override
    public boolean isNew() {
        return Objects.isNull(id);
    }
}
