package com.intexsoft.javacourse.tsymmerman;

import com.intexsoft.javacourse.tsymmerman.services.HalloWorldBean;
import com.intexsoft.javacourse.tsymmerman.services.SenderSpring;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kenasan on 26.05.2019.
 */
@Configuration
public class RabbitAmqpConfig {

    @Bean
    public HalloWorldBean halloWorldBean() {
        return new HalloWorldBean();
    }

    @Bean
    public SenderSpring senderSpring() {
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