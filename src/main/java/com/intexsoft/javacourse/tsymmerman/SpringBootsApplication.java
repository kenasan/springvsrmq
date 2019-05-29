package com.intexsoft.javacourse.tsymmerman;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by kenasan on 29.05.2019.
 */
@SpringBootApplication
@EnableScheduling
@Log4j
public class SpringBootsApplication {

    @Bean
    public CommandLineRunner tutorial() {
        return new Runner();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootsApplication.class, args);
        log.info("run");
    }
}
