package com.intexsoft.javacourse.tsymmerman;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class that start application with SpringBoot.
 */
@SpringBootApplication
@Log4j
public class AmqpSenderApplication {

    /**
     * Main method to bootstrap application.
     *
     * @param args - arguments that can taking from console.
     * @throws Exception
     */
    public static void main(String[] args) {
        try {
            SpringApplication.run(AmqpSenderApplication.class, args);
        } catch (Exception e) {
            log.error("Can't run AmqpSenderApplication with springBoot. Have exception: " + e);
        }
    }
}
