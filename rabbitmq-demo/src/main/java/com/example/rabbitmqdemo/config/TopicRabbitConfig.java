package com.example.rabbitmqdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    final static String message="topic.message";
    final static String messages="topic.messages";
    @Bean
    public Queue queueMessage(){
        return new Queue(TopicRabbitConfig.message);
    }
    @Bean
    public Queue queueMessages(){
        return new Queue(TopicRabbitConfig.messages);
    }
    @Bean
    TopicExchange exchange(){
        return new TopicExchange("exchange");
    }
    @Bean
    Binding bindingExchangeMessage(Queue queue,TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("topic.message");
    }
    @Bean
    Binding bindingExchangeMessages(Queue queue,TopicExchange exchange){
        return BindingBuilder.bind(queueMessages()).to(exchange).with("topic.#");
    }
}
