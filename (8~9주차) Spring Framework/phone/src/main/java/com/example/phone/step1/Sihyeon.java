package com.example.phone.step1;

public class Sihyeon {
    private Galaxy galaxy;
    private IPhone iPhone;  
    
    public Sihyeon() {
        this.galaxy = new Galaxy();
        this.iPhone = new IPhone();
    }

    public void usePhones() {
        galaxy.powerOn();
        galaxy.useSamsungPay();
        
        iPhone.powerOn();
        iPhone.useApplePay();
    }
}