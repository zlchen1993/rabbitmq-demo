package com.example.rabbitmqdemo;

import com.example.rabbitmqdemo.rabbit.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TopicTest {
    @Autowired
    private TopicSender topicSender;
    @Test
    public void topic() throws Exception {
        topicSender.send();
    }

    @Test
    public void topic1() throws Exception {
        topicSender.send1();
    }

    @Test
    public void topic2() throws Exception {
        topicSender.send2();
    }
}
