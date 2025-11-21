package com.example.phone.step3;

public class AppConfig {
    public Phone phone() {
        return new IPhone();
    }

    public Sihyeon sihyeon() {
        return new Sihyeon(phone());
    }
}
