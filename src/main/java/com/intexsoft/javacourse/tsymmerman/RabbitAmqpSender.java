package com.intexsoft.javacourse.tsymmerman;

import com.intexsoft.javacourse.tsymmerman.services.SenderSpring;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by kenasan on 26.05.2019.
 */
@Log4j
public class RabbitAmqpSender {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(RabbitAmqpConfig.class);
        SenderSpring senderSpring = context.getBean(SenderSpring.class);
        senderSpring.setMessage("message.queueSpring");
        senderSpring.send();
    }
}