package com.chap07.ex03_nested;
class OuterClass{
    String field = "외부 클래스의 필드(인스턴스 변수)";
    class InnerClass{
        String field = "내부 클래스 필드";
        void accessOuter(){
            System.out.println(this.field);
            System.out.println(OuterClass.this.field);
        }
    }

    void createInner(){
        InnerClass inner = new InnerClass();
        inner.accessOuter();
    }
}

public class NestedAccessMain{
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        //outer.createInner();
        OuterClass.InnerClass oi = outer.new InnerClass();
        oi.accessOuter();
    }
}
