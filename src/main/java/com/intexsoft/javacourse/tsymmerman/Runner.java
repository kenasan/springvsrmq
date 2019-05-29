package com.intexsoft.javacourse.tsymmerman;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by kenasan on 27.05.2019.
 */
@Log4j
public class Runner implements CommandLineRunner {

    @Autowired
    private ConfigurableApplicationContext ctx;

    public void run(String... args) throws Exception {
        log.info("run to thread.sleep");
        Thread.sleep(10000);
        ctx.close();
    }
}