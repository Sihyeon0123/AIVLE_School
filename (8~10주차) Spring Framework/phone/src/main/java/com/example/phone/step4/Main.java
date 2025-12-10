package com.example.phone.step4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = 
            new AnnotationConfigApplicationContext(AppConfig.class);
        
        Sihyeon sihyeon = applicationContext.getBean("sihyeon", Sihyeon.class);
        sihyeon.usePhones();
        ((AnnotationConfigApplicationContext) applicationContext).close();
    }
}