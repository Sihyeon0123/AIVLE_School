package com.chap06.ex01_class_basics;

public class Box {
    int size;
    // Box 클래스의 매개변수가 있는 생성자
    public Box() {}
    public Box(int size) {
        this.size = size;
        System.out.println("Box 생성자 호출됨, 크기 : " + size);
    }
}

class ColorBox extends Box{
    String color;

    public ColorBox(int size, String color) {
        super(size); // 부모 생성자 호출인데 명시적 호출
        this.color = color;
        System.out.println("colorBox 생성자 호출됨, " +
                "크기 : " + this.size +
                ", 색상 : " + this.color);
    }
}

class InheritanceConstructorMain{
    public static void main(String[] args) {
        ColorBox cBox = new ColorBox(2, "red");
    }
}