package com.intexsoft.javacourse.tsymmerman.util;

import com.intexsoft.javacourse.tsymmerman.Message;
import com.intexsoft.javacourse.tsymmerman.services.AmqpSender;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;

/**
 * ConsoleScanRunner scanning input arguments from console and
 * send it from AmqpSender into the amqp queue.
 */
@Log4j
public class ConsoleScanRunner implements CommandLineRunner {
    @Autowired
    Message message;
    @Autowired
    AmqpSender amqpSender;
    Scanner scanner;

    /**
     * Constructor to start Scanner.
     */
    public ConsoleScanRunner() {
        scanner = new Scanner(System.in);
    }

    public void run(String... args) throws Exception {
        log.info(" Write your message to send at the Amqp queue.");
        consoleScanning();
    }

    private void consoleScanning() {
        String textConsole = scanner.next();
        if (textConsole.equals(null)){
            log.info("Empty message, repeat please");
            consoleScanning();
        }
        message.setBody(textConsole);
        amqpSender.send(message);
        consoleScanning();
    }
}