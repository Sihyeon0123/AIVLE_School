package com.chap07.ex02_interface;
interface InterfaceA extends InterfaceB, InterfaceC{
    void methodA();
}
interface InterfaceB{
    void methodB();
}

interface InterfaceC {
    void methodC();
}
class ImplementClass implements InterfaceA{
    @Override
    public void methodA() {
        System.out.println("InterfaceA의 methodA 구현");
    }

    @Override
    public void methodB() {
        System.out.println("InterfaceB의 methodB 구현");
    }

    @Override
    public void methodC() {
        System.out.println("InterfaceB의 methodB 구현");
    }
}
public class InheritanceMain {
    public static void main(String[] args) {
        InterfaceA A = new ImplementClass();

        A.methodA();
        A.methodB();
        A.methodC();
    }
}
