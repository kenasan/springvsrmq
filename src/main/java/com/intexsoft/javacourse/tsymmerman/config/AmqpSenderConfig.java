package com.intexsoft.javacourse.tsymmerman.config;

import com.intexsoft.javacourse.tsymmerman.Message;
import com.intexsoft.javacourse.tsymmerman.services.AmqpSender;
import com.intexsoft.javacourse.tsymmerman.util.ConsoleScanRunner;
import lombok.extern.log4j.Log4j;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring create bean of writing there classes.
 */
@Log4j
@Configuration
public class AmqpSenderConfig {

    @Bean
    public AmqpSender senderSpring() {
        return new AmqpSender();
    }

    @Bean
    public Message message() {
        return new Message();
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("localhost");
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new ConsoleScanRunner();
    }
}