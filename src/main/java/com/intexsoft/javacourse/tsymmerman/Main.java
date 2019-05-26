package com.intexsoft.javacourse.tsymmerman;

import com.intexsoft.javacourse.tsymmerman.services.HalloWorldBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by kenasan on 26.05.2019.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HalloWorldConfig.class);
        HalloWorldBean halloWorldBean = context.getBean(HalloWorldBean.class);
        String message = halloWorldBean.sayHello();
        System.out.println(message);
    }
}