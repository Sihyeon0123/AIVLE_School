package com.chap06.ex04_constructor;

// 부모 클래스, 다양한 상자를 나타냄
class Box {
    int size;

    // Box 클래스의 매개변수가 있는 생성자
    public Box(int size) {
        this.size = size;
        System.out.println("Box 생성자 호출됨, 크기: " + size);
    }
}

// Box 클래스를 상속받아 색상이 있는 상자를 나타내는 ColoredBox 클래스
class ColorBox extends Box {
    String color;

    // ColorBox 클래스의 생성자에서 super()를 이용해 부모 클래스의 생성자를 명시적으로 호출
    public ColorBox(int size, String color) {
        super(size);   // 부모 클래스의 생성자 호출
        this.color = color;
        System.out.println("ColorBox 생성자 호출됨, 색상: " + color);
    }
}

// 실행 클래스
@SuppressWarnings("unused")
public class InheritanceConstructorMain {
    public static void main(String[ ] args) {
        // ColorBox 객체 생성
        ColorBox cBox = new ColorBox(10, "Red");
    }
}