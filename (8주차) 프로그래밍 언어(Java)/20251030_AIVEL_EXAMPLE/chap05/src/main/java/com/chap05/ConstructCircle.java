package com.chap05;

class CircleClass {
    private double radius = 1.0;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

public class ConstructCircle {
    public static void main(String[] args) {
        CircleClass myCircle = new CircleClass(); // 디폴트 생성자 호출
        System.out.println("반지름 : " + myCircle.getRadius());
    }
}
