package com.example.phone.step5;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary    // 이 클래스가 기본 빈으로 선택되도록 지정
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