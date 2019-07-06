package com.intexsoft.javacourse.tsymmerman.config;

import com.intexsoft.javacourse.tsymmerman.services.AmqpSender;
import com.intexsoft.javacourse.tsymmerman.util.ConsoleScanRunner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring create bean of writing there classes.
 */
@Slf4j
@Configuration
public class AmqpSenderConfig {

    @Value("${rabbitmq.host}")
    String rabbitMqHost;
    @Value("${rabbitmq.password}")
    String rabbitMqPassword;
    @Value("${rabbitmq.user_name}")
    String rabbitMqUserName;
    @Value("${rabbitmq.port}")
    int rabbitMqPort;

    // todo java doc

    /**
     * Create helper class that simplifies synchronous RabbitMQ access
     * (sending and receiving messages).
     *
     * @return instance of RabbitTemplate , with connection to rabbitMq,
     * see port of connection at application.properties.
     */
    @Bean
    public RabbitTemplate rabbitTemplate() {
        com.rabbitmq.client.ConnectionFactory connectionFactory = new com.rabbitmq.client.ConnectionFactory();
        connectionFactory.setHost(rabbitMqHost);
        connectionFactory.setUsername(rabbitMqUserName);
        connectionFactory.setPort(rabbitMqPort);
        connectionFactory.setPassword(rabbitMqPassword);
        return new RabbitTemplate(new CachingConnectionFactory(connectionFactory));
    }

    /**
     * Create bean of AmqpSender which send messages in exchange of rabbitMq.
     *
     * @return instance using creating later rabbitTemplate.
     */
    @Bean
    public AmqpSender senderSpring() {
        return new AmqpSender(rabbitTemplate());
    }

    // todo java doc

    /**
     * CommandLineRunner used to indicate that a bean should run when
     * it is contained within SpringApplication
     *
     * @return instance of ConsoleScanRunner that will be running.
     */
    @Bean
    public CommandLineRunner commandLineRunner() {
        return new ConsoleScanRunner();
    }
}