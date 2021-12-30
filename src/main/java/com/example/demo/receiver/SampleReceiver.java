package com.example.demo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class SampleReceiver {

    @RabbitListener(queues = "sample-queue")
    public void receive(String msg) {
        System.out.println(msg);
    }

}
