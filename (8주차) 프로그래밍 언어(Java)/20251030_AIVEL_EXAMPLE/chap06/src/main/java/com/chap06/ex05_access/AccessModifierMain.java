package com.chap06.ex05_access;

class AccessModifierMain{
    public static void main(String[] args) {
        //Child child = new Child();
        //child.show(); // Child 클래스의 메소드를 통해 변수와 메소드에 접근

        Parent parent = new Parent();
        System.out.println(parent.publicVar); // public 접근 가능
        // 아래 접근 지정자들은 Parent 인스턴스를 통해서는 접근 불가능
        //System.out.println(parent.protectedVar); // protected 접근 불가
        //System.out.println(parent.defaultVar); // default 접근 불가
        //System.out.println(parent.privateVar); // private 접근 불가

        parent.publicMethod(); // public 메소드 호출 가능
        // parent.protectedMethod(); // protected 메소드 호출 불가
        // parent.defaultMethod(); // default 메소드 호출 불가
        // parent.privateMethod(); // private 메소드 호출 불가
    }
}