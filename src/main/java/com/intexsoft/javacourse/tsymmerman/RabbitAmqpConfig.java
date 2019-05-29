package com.intexsoft.javacourse.tsymmerman;

import com.intexsoft.javacourse.tsymmerman.services.SenderSpring;
import lombok.extern.log4j.Log4j;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created by kenasan on 26.05.2019.
 */
@Log4j
@SpringBootConfiguration
public class RabbitAmqpConfig {

    @Bean
    public SenderSpring senderSpring() {
        log.info("Hallo");
        return new SenderSpring();
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("localhost");
        return connectionFactory;
    }
}