package com.example.phone.step5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    /** Phone이라는 interface를 iphone과 galaxy 2개가 구현되어 컴포넌트 충돌 
     * @Primary 로 기본빈을 설정하여 해결
     * 의존성 주입
    */
    public static void main(String[] args) {
        ApplicationContext applicationContext = 
            new AnnotationConfigApplicationContext(AppConfig.class);
        
        Sihyeon sihyeon = applicationContext.getBean("sihyeon", Sihyeon.class);
        sihyeon.usePhones();
    }
}