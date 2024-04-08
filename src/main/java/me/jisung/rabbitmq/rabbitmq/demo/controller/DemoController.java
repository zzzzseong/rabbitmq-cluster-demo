package me.jisung.rabbitmq.rabbitmq.demo.controller;

import lombok.RequiredArgsConstructor;
import me.jisung.rabbitmq.rabbitmq.demo.rabbitMQ.RMQProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/demo/rabbitmq")
public class DemoController {

    private final RMQProducer RMQProducer;

    @PostMapping("/produce")
    public void produce() {
         RMQProducer.produce("demo_queue", "Hello, RabbitMQ!");
    }
}
