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
    private int i;

    /**
     * Constructor to initialize Scanner.
     */

    public ConsoleScanRunner() {
        scanner = new Scanner(System.in);
    }

    /**
     * Method run will be start after load springApplication and
     * create bean with indicate CommandLineRunner.
     *
     * @param args input messages fo Amqp queue.
     */
    @Override
    public void run(String... args) {
        System.out.println(" Write your message to send at the Amqp queue.");
        while (i <= 10) {
            consoleScanning();
            i++;
        }
    }

    // todo разобраться с желтым
    private void consoleScanning() {
        String textConsole = scanner.next();
        amqpSender.send(textConsole);
    }
}