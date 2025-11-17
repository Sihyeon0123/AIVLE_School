package com.chap07.ex01_abstraction;

public class MyClass implements MyInterface{
    @Override
    public void sayHello() {
        //MAX = 11;
        System.out.println("안녕하세요, 최대값은: " + MAX);
    }
}
