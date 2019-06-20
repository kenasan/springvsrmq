package com.intexsoft.javacourse.tsymmerman.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * Send a message at the amqp queue.
 */
@Slf4j
public class AmqpSender {

    @Value("${rabbitmq.exchange_name}")
    protected String exchangeName;
    @Value("${rabbitmq.routing_key}")
    protected String routingKey;

    @Autowired
    private RabbitTemplate template;

    /**
     * Constructor of AmqpSender to assigned template
     * (without it has marked yellow).
     *
     * @param template instants of RabbitTemplate,
     *                 which has method convertAndSend,
     *                 message to exchange.
     */
    public AmqpSender(RabbitTemplate template) {
        this.template = template;
    }

    /**
     * Method witch send a message.
     *
     * @param message - object of class Message that take body of sending message at the queue.
     */
    public void send(String message) {
        template.convertAndSend(exchangeName, routingKey, message);
        log.info("AmqpSender sent a message at the queue : " + message);
    }
}
