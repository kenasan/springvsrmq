package com.intexsoft.javacourse.tsymmerman;

import com.intexsoft.javacourse.tsymmerman.services.SenderSpring;
import lombok.extern.log4j.Log4j;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kenasan on 26.05.2019.
 */
@Log4j
@Configuration
public class RabbitAmqpConfig {

    @Bean
    public SenderSpring senderSpring() {
        return new SenderSpring();
    }
    @Bean
    public Message message(){
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
}