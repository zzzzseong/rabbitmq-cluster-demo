package me.jisung.rabbitmq.rabbitmq.demo.rabbitMQ;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RMQProducer {

    private final RabbitTemplate rabbitTemplate;

    public void enqueue(String queue, String message) {
        rabbitTemplate.convertAndSend(queue, message);
    }
}
