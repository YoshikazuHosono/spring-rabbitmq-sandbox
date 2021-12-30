package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.receiver.SampleReceiver;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {

    @Value("${app-config.rabbitmq.exchange-name}")
    private String topicExchangeName;

    private final AmqpTemplate amqpTemplate;

    @GetMapping("/sendMsg")
    public void sendMsg() {
        Message message = new Message("msg".getBytes(), new MessageProperties());
        amqpTemplate.send(topicExchangeName, null, message);
    }

}
