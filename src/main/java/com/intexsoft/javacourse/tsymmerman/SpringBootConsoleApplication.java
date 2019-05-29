package com.intexsoft.javacourse.tsymmerman;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by kenasan on 27.05.2019.
 */
@Log4j
@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        log.info("Hallo");
        SpringApplication.run(RabbitAmqpConfig.class, args);
    }

    public void run(String... args) throws Exception {
        Thread.sleep(10000);
    }
}