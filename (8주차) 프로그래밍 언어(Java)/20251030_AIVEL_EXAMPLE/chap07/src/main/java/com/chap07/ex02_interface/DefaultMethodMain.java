package com.chap07.ex02_interface;

interface A{
    void method1();
    default void method2(){
        System.out.println("디폴트 메서드");
    }
    default void method3(){
        System.out.println("디폴트 메서드");
    }
}

class C1 implements A{

    @Override
    public void method1() {
        System.out.println("C1에서 method1() 구현");
    }
}

class D1 implements A{

    @Override
    public void method1() {
        System.out.println("D1에서 method1() 구현");
    }

    @Override
    public void method2() {
        System.out.println("D1에서 method2()를 오버라이드함");
    }
}


public class DefaultMethodMain {

    public static void main(String[] args) {
        /*
        A c1 = new C1();
        c1.method1(); // "C1에서 method1() 구현" 출력
        c1.method2(); // "디폴트 메서드 실행" 출력
        */


        A d1 = new D1();
        d1.method1(); // "D1에서 method1() 구현" 출력
        d1.method2(); // "D1에서 method2()를 오버라이드함" 출력

    }
}
