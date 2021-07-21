package com.example.rabbitmqdemo.rabbit.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context="hello" + LocalDateTime.now();
        System.out.println("sender:"+context);
        this.amqpTemplate.convertAndSend("hello",context);

    }
}
