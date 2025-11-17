package com.chap07.ex01_abstraction;
public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        //super(); // 부모의 디폴트 생성자 호출
        this.radius = radius;
    }
    @Override
    void draw() {
        System.out.println("원 그림. 반지름 : " + radius);
    }
}
