package com.example.rabbitmqdemo.rabbit.object;

import com.example.rabbitmqdemo.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {
    @RabbitHandler
    public void receive(User user){
        System.out.println("receiver object:"+user);
    }
}
