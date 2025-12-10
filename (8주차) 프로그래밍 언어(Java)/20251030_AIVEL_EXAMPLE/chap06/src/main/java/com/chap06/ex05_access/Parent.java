package com.chap06.ex05_access;

@SuppressWarnings("unused")
public class Parent {
    public String publicVar = "public: 모든 클래스에서 접근 가능";
    protected String protectedVar = "protected: 같은 패키지 또는 상속받은 클래스에서 접근 가능";
    String defaultVar = "default: 같은 패키지 내에서만 접근 가능";
    private String privateVar = "private: 같은 클래스 내에서만 접근 가능";

    public void publicMethod() {
        System.out.println("public 메소드: 어디서든 호출 가능");
    }
    protected void protectedMethod() {
        System.out.println("protected 메소드: 같은 패키지 또는 자식 클래스에서 호출 가능");
    }
    void defaultMethod() {
        System.out.println("default 메소드: 같은 패키지 내에서만 호출 가능");
    }
    private void privateMethod() {
        System.out.println("private 메소드: 이 클래스 내에서만 호출 가능");
    }
}
