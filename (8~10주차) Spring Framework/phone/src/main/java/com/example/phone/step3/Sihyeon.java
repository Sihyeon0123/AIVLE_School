package com.example.phone.step3;

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