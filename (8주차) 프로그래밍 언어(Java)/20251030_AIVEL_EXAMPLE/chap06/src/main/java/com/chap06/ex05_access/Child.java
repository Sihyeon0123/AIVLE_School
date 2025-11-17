package com.chap06.ex05_access;

public class Child extends Parent {
    public void show() {
        System.out.println(publicVar); // public 접근 가능
        System.out.println(protectedVar); // protected 접근 가능
        System.out.println(defaultVar); // default 접근 가능(같은 패키지 내)
        //System.out.println(privateVar); // private 접근 불가 - 컴파일 에러 발생

        publicMethod(); // public 메소드 호출 가능
        protectedMethod(); // protected 메소드 호출 가능
        defaultMethod(); // default 메소드 호출 가능(같은 패키지 내)
        //privateMethod(); // private 메소드 호출 불가 - 컴파일 에러 발생
    }
}
