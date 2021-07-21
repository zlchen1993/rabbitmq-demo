package com.example.rabbitmqdemo.rabbit.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate template;

    public void send(){
        String context="Hi,fount msg!";
        System.out.println("sender:"+context);
        this.template.convertAndSend("fanoutExchange","",context);
    }
}
