package com.intexsoft.javacourse.tsymmerman.services;

import com.intexsoft.javacourse.tsymmerman.Message;
import lombok.extern.log4j.Log4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kenasan on 27.05.2019.
 */
@Log4j
public class SenderSpring {
    @Autowired
    private RabbitTemplate template;

    public void send(Message message) {
        template.convertAndSend("queueSpring", message.getBody());
        log.info("SenderSpring send a message : " + message.getBody());
    }
}
