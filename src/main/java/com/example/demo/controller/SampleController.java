package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.receiver.SampleReceiver;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {

    public static final String topicExchangeName = "spring-boot-exchange";

    private final RabbitTemplate rabbitTemplate;
    private final SampleReceiver receiver;

    @GetMapping("/sendMsg")
    public void sendMsg() {
        rabbitTemplate.convertAndSend(DemoApplication.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
    }

}
