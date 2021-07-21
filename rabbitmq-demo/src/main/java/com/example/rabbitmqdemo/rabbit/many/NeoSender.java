package com.example.rabbitmqdemo.rabbit.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NeoSender {

    @Autowired
    private AmqpTemplate template;


    public void send(int i){
        String context="spring boot neo queue"+"*****"+i;
        System.out.println("sender1:"+context);
        this.template.convertAndSend("neo",context);
    }
}
