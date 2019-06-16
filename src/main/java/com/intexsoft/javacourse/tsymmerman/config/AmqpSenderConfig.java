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

    // todo java doc
    @Bean
    public AmqpSender senderSpring() {
        return new AmqpSender();
    }

    // todo java doc
    // todo зачем бин?
    @Bean
    public Message message() {
        return new Message();
    }

    // todo java doc
    @Bean
    public ConnectionFactory connectionFactory() {
        // todo использовать @Value и .properties файл
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("localhost"); // todo сделать inline, создавать инстанс -- лишнее
        return connectionFactory;
    }

    // todo java doc
    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    // todo java doc
    @Bean
    public CommandLineRunner commandLineRunner() {
        return new ConsoleScanRunner();
    }
}
