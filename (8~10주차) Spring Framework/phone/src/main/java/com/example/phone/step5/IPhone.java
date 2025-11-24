package com.example.phone.step5;

import org.springframework.stereotype.Component;

@Component
public class IPhone implements Phone {
    @Override
    public void powerOn() {
        System.out.println("Hello iPhone");
    }

    @Override
    public void usePay() {
        System.out.println("Use Apple Pay");
    }
}