package com.chap07.ex03_nested;
abstract class Parent{
    void show(){
        System.out.println("Parent의 show() 메서드");
    }
    abstract void print();
}
public class AnonymousClassMain {
    public static void main(String[] args) {
        Parent p = new Parent() {
            String name = "홍길동";
            @Override
            void show() {
                //super.show();
                System.out.println("익명 자식 클래스의 show() 메서드 " + name);
            }
            @Override
            void print() {
                System.out.println("익명 자식 클래스의 print() 메서드 " + name);
            }
        };

        p.show();
        p.print();
    }
}
