package com.example.phone.step2;

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