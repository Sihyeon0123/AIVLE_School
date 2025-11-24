package com.example.phone.step3;

public class Galaxy implements Phone {
    @Override
    public void powerOn() {
        System.out.println("Hello Galaxy");
    }

    @Override
    public void usePay() {
        System.out.println("Use Samsung Pay");
    }
}