package com.intexsoft.javacourse.tsymmerman.services;

import com.intexsoft.javacourse.tsymmerman.constants.AmqpConstants;
import lombok.extern.log4j.Log4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Send a message at the amqp queue.
 */
@Log4j
public class AmqpSender {
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
        template.convertAndSend(AmqpConstants.EXCHANGE_NAME, AmqpConstants.ROUTING_KEY, message);
        log.info("AmqpSender sent a message at the queue : " + message);
    }
}
