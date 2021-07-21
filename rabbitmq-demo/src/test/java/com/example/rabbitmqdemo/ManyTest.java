package com.example.rabbitmqdemo;

import com.example.rabbitmqdemo.rabbit.many.NeoSender;
import com.example.rabbitmqdemo.rabbit.many.NeoSender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ManyTest {

    @Autowired
    private NeoSender neoSender;
    @Autowired
    private NeoSender2 neoSender2;
    @Test
    public void testOneToMany() throws Exception{
        for (int i = 0; i <100 ; i++) {
            neoSender.send(i);
        }
    }

    @Test
    public void testManyToMany()throws Exception{
        for (int i = 0; i <100 ; i++) {
            neoSender.send(i);
            neoSender2.send(i);
        }
    }
}
