package com.example.phone.step2;        

public class Main {
    public static void main(String[] args) {
        /** new Galaxy로 객체를 생성하던 책임을 제거하고 
         * 외부로부터 주입받도록 수정 
         * [단일책임원칙]*/
        Sihyeon sihyeon = new Sihyeon(new Galaxy());
        sihyeon.usePhones();
    }
}