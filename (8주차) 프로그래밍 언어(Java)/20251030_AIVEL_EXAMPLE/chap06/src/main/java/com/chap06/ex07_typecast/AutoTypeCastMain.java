package com.chap06.ex07_typecast;

public class AutoTypeCastMain {
    public static void main(String[] args) {
        // s 객체는 Student 타입일 수있고, Person 타입
        Student s = new Student("학생", 7);
        Person p; // 참조 변수 Person 타입의 객체참조값
        p = s; // p는 Person 타입이기 때문에 반드시 Person 타입 객체의 참조값 넣어야함.
        p.whoami();
    }
}
