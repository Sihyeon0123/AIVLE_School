package com.chap05;

class Ball{
    double radius;

    public Ball(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

public class Prim {
    public static void main(String[] args) {
        int a = 10;
        int b = a; // 무시
        b = 20;

        System.out.println("a의 값 : " + a); // 10
        System.out.println("b의 값 : " + b); // 20

        Ball myBall = new Ball(4.0);
        Ball yourBall = myBall;
        yourBall.setRadius(5.0);

        System.out.println("myBall의 반지름 : " + myBall.radius); // 5.0
        System.out.println("yourall의 반지름 : " + yourBall.radius); // 5.0

    }
}
