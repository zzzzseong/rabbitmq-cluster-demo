package me.jisung.rabbitmq.rabbitmq.demo.controller;

import lombok.RequiredArgsConstructor;
import me.jisung.rabbitmq.rabbitmq.demo.constraints.RMQConst;
import me.jisung.rabbitmq.rabbitmq.demo.dto.MessageRequestDto;
import me.jisung.rabbitmq.rabbitmq.demo.rabbitMQ.RMQConsumer;
import me.jisung.rabbitmq.rabbitmq.demo.rabbitMQ.RMQProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/demo/rabbitmq")
public class DemoController {

    private final RMQProducer RMQProducer;
    private final RMQConsumer RMQConsumer;

    @PostMapping("/enqueue")
    public void enqueue(@RequestBody MessageRequestDto request) {
         RMQProducer.enqueue(RMQConst.RMQ_QUEUE_DEMO, request.getMessage());
    }

    @PostMapping("/consume")
    public void consume() {
        RMQConsumer.consumeManually();
    }
}
