package com.chap07.ex02_interface;
class OuterClass{
    // 필드, 메서드, 클레스
    private String name = "홍길동";
    class NestedClass{
        // 중첩 클래스의 메서드
        void nestedMethod() {
            System.out.println("이것은 중첩된 클래스의 메서드임. " + OuterClass.this.name);
        }
    }
    void printName(){
        System.out.println("내 이름은 " + name);
    }
    // 중첩 인터페이스(Nested Interface) 예제
    interface NestedInterface {
        // 중첩 인터페이스의 메서드명을 'display'로 변경
        void display();
    }
}

class ImplementOuterClass implements OuterClass.NestedInterface{

    @Override
    public void display() {
        System.out.println("중첩 인터페이스의 메서드 구현.");
    }
}

public class NestedMain {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.printName();

        OuterClass.NestedClass nested = outer.new NestedClass();
        nested.nestedMethod();

        OuterClass.NestedInterface nestedInterface = new ImplementOuterClass();
        nestedInterface.display();
    }
}
