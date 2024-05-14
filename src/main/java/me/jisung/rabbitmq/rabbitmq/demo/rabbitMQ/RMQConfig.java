package me.jisung.rabbitmq.rabbitmq.demo.rabbitMQ;

import me.jisung.rabbitmq.rabbitmq.demo.constraints.RMQConst;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RMQConfig {

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());

        rabbitTemplate.containerAckMode(AcknowledgeMode.MANUAL);

        return rabbitTemplate;
    }

    private ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();

        connectionFactory.setHost(RMQConst.HOST);
        connectionFactory.setPort(RMQConst.PORT);
        connectionFactory.setUsername(RMQConst.USERNAME);
        connectionFactory.setPassword(RMQConst.PASSWORD);

        return connectionFactory;
    }

}
