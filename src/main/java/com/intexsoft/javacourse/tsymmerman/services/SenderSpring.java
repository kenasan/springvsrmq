package com.intexsoft.javacourse.tsymmerman.services;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by kenasan on 27.05.2019.
 */
@Log4j
public class SenderSpring {
    @Autowired
    private RabbitTemplate template;
    private int i;
    @Setter
    @Getter
    private String message = "qwerty" + i;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        template.convertAndSend("queueSpring", message);
        log.info("SenderSpring send a message : " + message);
        i++;
    }
}
