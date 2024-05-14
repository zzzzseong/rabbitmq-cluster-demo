package me.jisung.rabbitmq.rabbitmq.demo.rabbitMQ;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jisung.rabbitmq.rabbitmq.demo.constraints.RMQConst;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j(topic = "RMQConsumer")
public class RMQConsumer {

    private final RabbitTemplate rabbitTemplate;

    /**
     * Consuming message using rabbitListener annotation
     * @param message consumed message
     * */
    @RabbitListener(queues = RMQConst.RMQ_QUEUE_DEMO)
    public void consume(String message) {
        log.info("Message consumed from {}: {}", RMQConst.RMQ_QUEUE_DEMO, message);
    }

    /**
     * Consuming message manually using rabbitTemplate
     * */
    public void consumeManually() {
        String message = String.valueOf(rabbitTemplate.receiveAndConvert(RMQConst.RMQ_QUEUE_DEMO));

        log.info("Message consumed manually from {}: {}", RMQConst.RMQ_QUEUE_DEMO, message);
    }
}
