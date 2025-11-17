package com.chap05;

public class Circle {
    //필드(인스턴스 변수들의 선언)
    private double radius;

    public Circle(double radius) {
        // this : 내 자신의 객체를 의미
        this.radius = radius;
        System.out.println("내부에서 원의 넓이 출력 : "+ findArea());
    }

    double findArea(){
        return Math.PI * this.radius * radius;
    }

    public static void main(String[] args) {
        Circle myCircle;
        myCircle = new Circle(2.0);
        System.out.println("외부에서 원의 넓이 출력 : " + myCircle.findArea());
    }
}
