package com.intexsoft.javacourse.tsymmerman.util;

import com.intexsoft.javacourse.tsymmerman.services.AmqpSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;

/**
 * ConsoleScanRunner scanning input arguments from console and
 * send it from AmqpSender into the amqp queue.
 */
@Slf4j
public class ConsoleScanRunner implements CommandLineRunner {
    @Autowired
    private AmqpSender amqpSender;
    private Scanner scanner;

    /**
     * Constructor to start Scanner.
     */

    public ConsoleScanRunner() {
        scanner = new Scanner(System.in);
    }

    // todo ругается на то, что эксепшн не бросается тут

    /**
     * method run will be start after load springApplication and
     * create bean with indicate CommandLineRunner
     *
     * @param args
     */
    @Override
    public void run(String... args) {
        log.info(" Write your message to send at the Amqp queue.");
        try {
            consoleScanning();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // todo разобраться с желтым
    private void consoleScanning() throws Exception {
        String textConsole = scanner.next();
        amqpSender.send(textConsole);
        consoleScanning();
    }
}
