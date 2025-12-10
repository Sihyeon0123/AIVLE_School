package com.chap06.ex06_final;

// class에서 final 더이상 상속 할 수 없다
class ConstData {
    public final static int MAX_SIZE = 10; // 인스턴스 변수 final 상수 쓰겠다
    // mathod에서 final 오버라이딩 할 수 업다.
    public static void display(){
        System.out.println("MAX_SIZE : " + MAX_SIZE);
    }
}
class ExtendedData extends ConstData{
    public static void display() {
        System.out.println("Cannot override");
   }
}
public class FinalMain {
    public static void main(String[] args) {
        ConstData.display();      // static 방식 호출
        ExtendedData.display();   // static 방식 호출
    }
}