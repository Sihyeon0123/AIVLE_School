package com.chap06.ex02_inheritance;

// 기본 클래스
class Base {
    int num;      // 기본 클래스 필드

    // 기본 클래스 생성자
    Base(int num) {
        this.num = num;
    }

    // num 필드 값을 반환하는 메소드
    int getNum() {
        return num;
    }
}

// 기본 클래스 상속받는 하위 클래스
class Derived extends Base {
    // 하위 클래스 생성자
    Derived(int val) {
        super(val);   // 부모 클래스의 생성자 호출
    }

    // 기본 클래스의 메소드를 오버라이드
    @Override
    int getNum() {
        return num * num;   // 제곱된 값을 반환
    }
}

// 실행 클래스
public class NumTest {
    public static void main(String[ ] args) {
        Base b = new Base(10);    // 기본 클래스 객체 생성
        Derived d = new Derived(10);  // 하위 클래스 객체 생성

        // 각 객체의 num 값 출력
        System.out.println("기본 객체의 num 값: " + b.getNum());
        System.out.println("하위 객체의 num 값: " + d.getNum());
    }
}