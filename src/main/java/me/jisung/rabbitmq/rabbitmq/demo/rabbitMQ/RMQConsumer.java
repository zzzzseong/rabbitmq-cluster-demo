package me.jisung.rabbitmq.rabbitmq.demo.rabbitMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RMQConsumer {

    private final Logger logger = LoggerFactory.getLogger(RMQConsumer.class);

    @RabbitListener(queues = "demo_queue")
    public void consume() {
        logger.info("Message consumed from demo_queue");
    }
}
