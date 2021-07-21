package com.example.rabbitmqdemo.rabbit.object;

import com.example.rabbitmqdemo.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectSender {
    @Autowired
    private AmqpTemplate template;

    public void send(User user){
        System.out.println("sender object:"+user.toString());
        this.template.convertAndSend("object",user);
    }
}
