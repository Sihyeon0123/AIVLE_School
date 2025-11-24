package com.example.phone.step4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Phone phone() {
        return new IPhone();
    }

    @Bean
    public Sihyeon sihyeon() {
        return new Sihyeon(phone());
    }
}
