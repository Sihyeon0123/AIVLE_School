package com.example.phone.step2;

public class Sihyeon {
    private Phone phone;
    
    public Sihyeon(Phone phone) {
        this.phone = phone;
    }

    public void usePhones() {
        phone.powerOn();
        phone.usePay();
    }
}