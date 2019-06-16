package com.intexsoft.javacourse.tsymmerman.services;

import com.intexsoft.javacourse.tsymmerman.Message;
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
     * Method witch send a message.
     *
     * @param message - object of class Message that take body of sending message at the queue.
     */
    //todo переделать на exchange
    public void send(Message message) {
        template.convertAndSend(AmqpConstants.QUEUE_NAME, message.getBody());
        log.info("AmqpSender sent a message at the queue : " + message.getBody());
    }
}
