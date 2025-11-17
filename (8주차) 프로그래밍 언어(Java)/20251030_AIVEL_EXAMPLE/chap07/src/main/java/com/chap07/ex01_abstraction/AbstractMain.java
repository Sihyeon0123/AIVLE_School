package com.chap07.ex01_abstraction;

public class AbstractMain {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        circle.draw();
        // 자식 클레스 타입의 객체를 부모 클레스 타입으로 형변환(다운케스트)
        // Shape Shape = (Shape)(new Circle(11));
        Shape Shape = new Circle(11);
        Shape.draw(); // 자식 클래스에서 오버라이드된 메소드가 호출
    }
}
