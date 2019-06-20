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

    @Value("${rabbitmq.port}")
    String rabbitMqPort;

    // todo java doc

    /**
     * Create helper class that simplifies synchronous RabbitMQ access
     * (sending and receiving messages).
     *
     * @return instance of RabbitTamplate , with connection to rabbitMq,
     * see port of connection at application.properties.
     */
    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(new CachingConnectionFactory(rabbitMqPort));
    }

    /**
     * Create bean of AmqpSender which send messages for exchange of the queues.
     *
     * @return instance using creating later rabbitTemplate.
     */
    @Bean
    public AmqpSender senderSpring() {
        return new AmqpSender(rabbitTemplate());
    }

    // todo java doc

    /**
     * CommandLineRunner interface used to indicate that a bean should run when
     * it is contained within SpringApplication
     *
     * @return instance of ConsoleScanRunner that will be running.
     */
    @Bean
    public CommandLineRunner commandLineRunner() {
        return new ConsoleScanRunner();
    }
}
