package com.example.rabbitmqdemo;


import com.example.rabbitmqdemo.rabbit.hello.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HelloTest {
    @Autowired
    private HelloSender sender;
    @Test
    public void hello() throws Exception{
        sender.send();
    }
}
