package com.chap05;

public class Demo {
    // 필드영역(인스턴스 변수들), 객체 맴버변수
    int field;

    public void showDiff(){
        int field = 7; // showDiff 지역변수 field
        this.field = field; // 인스턴스 변수 field <- showDiff 지역변수 field

        System.out.println("클래스 필드 : " + this.field);
        System.out.println("메서드 지역변수 : " + field);
    }

    public void changeField(){
        int field;
        this.field = 10;
    }

    public static void main(String[] args) {
        Demo di = new Demo();
        di.showDiff();
        di.changeField();
        System.out.println("변경되 클래스 필드 : " + di.field);
    }
}
