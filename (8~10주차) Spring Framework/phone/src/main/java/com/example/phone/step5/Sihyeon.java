package com.example.phone.step5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Sihyeon {
    private final Phone phone;
    
    @Autowired  // 이 생성자로 빈 주입을 명시
    public Sihyeon(@Qualifier("iphone") Phone phone) { // 특정 빈을 지정
        this.phone = phone;
    }


    public void usePhones() {
        phone.powerOn();
        phone.usePay();
    }
}