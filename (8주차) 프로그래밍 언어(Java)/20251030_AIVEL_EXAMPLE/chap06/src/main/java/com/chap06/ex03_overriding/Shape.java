package com.chap06.ex03_overriding;

public class Shape {
    // 도형의 넓이를 계산하는 메서드
    double area() {
        return 0;
    }
}
class Circle extends Shape{
    double r;

    public Circle(double r) {
        this.r = r;
    }
    @Override
    double area() {
        return Math.PI * r * r;
    }
}
class Ball extends Circle{
    public Ball(double r) {
        super(r);
    }

    @Override
    double area() {
        //return 4 * Math.PI * r * r;
        return 4 * super.area();
    }
}
class Cylinder extends Circle{
    double h;
    public Cylinder(double r, double h) {
        super(r);
        this.h = h;
    }

    @Override
    double area() {
        //double cy =  2 * Math.PI * r * r + 2 * Math.PI * r * h;
        return 2 * super.area() + 2 * Math.PI * super.r * h;
        //return cy;
    }
}
class Cone extends Circle{
    double h;

    public Cone(double r, double h) {
        super(r);
        this.h = h;
    }

    @Override
    double area() {
        double l = Math.sqrt(r * r + h * h); // 슬란트 높이
        return Math.PI * super.r * l + super.area(); // 밑면 넓이(super.area()) + 측면 넓이(Math.PI * super.r * l)
        //return Math.PI * r * (l + r);
    }
}
class ShapeMain{
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Cylinder cylinder = new Cylinder(5, 10);
        Ball ball = new Ball(5);
        Cone cone = new Cone(5, 10);

        System.out.println("Circle area: " + circle.area());
        System.out.println("Cylinder area: " + cylinder.area());
        System.out.println("Ball area: " + ball.area());
        System.out.println("Cone area: " + cone.area());
    }
}