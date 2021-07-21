package com.example.rabbitmqdemo;

import com.example.rabbitmqdemo.model.User;
import com.example.rabbitmqdemo.rabbit.object.ObjectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ObjectTest {
    @Autowired
    private ObjectSender sender;

    @Test
    public void testObject(){
        User user= User.builder().name("czl").pass("123456").build();
        sender.send(user);
    }

}
