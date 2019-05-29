package com.intexsoft.javacourse.tsymmerman;

import com.intexsoft.javacourse.tsymmerman.services.SenderSpring;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;

/**
 * Created by kenasan on 27.05.2019.
 */
@Log4j
public class Runner implements CommandLineRunner {
    Scanner scanner = new Scanner(System.in);
    //    @Autowired
//    private ConfigurableApplicationContext ctx;
    @Autowired
    Message message;
    @Autowired
    SenderSpring senderSpring;

    public void run(String... args) throws Exception {
        log.info("run to thread.sleep");
        scanning();
//        Thread.sleep(10000);

//        ctx.close();
    }

    private void scanning() {
        String textConsole = scanner.next();
        message.setBody(textConsole);
        log.info("get message: " + textConsole);
        senderSpring.send(message);
        scanning();
    }
}