package com.chap05;

public class CalculatorOverloading {
    // 정수 두 개 더하기
    int add(int a, int b) {
        System.out.println("add(int, int) 호출");
        return a + b;
    }

    // 정수 세 개 더하기
    int add(int a, int b, int c) {
        System.out.println("add(int, int, int) 호출");
        return a + b + c;
    }

    // 실수 두 개 더하기
    double add(double a, double b) {
        System.out.println("add(double, double) 호출");
        return a + b;
    }

    // 문자열 연결
    String add(String a, String b) {
        System.out.println("add(String, String) 호출");
        return a + b;
    }

    public static void main(String[] args) {
        CalculatorOverloading calc = new CalculatorOverloading();

        // 오버로딩된 메서드 호출
        System.out.println("결과: " + calc.add(10, 20));
        System.out.println("결과: " + calc.add(10, 20, 30));
        System.out.println("결과: " + calc.add(10.5, 20.3));
        System.out.println("결과: " + calc.add("Hello, ", "World!"));
    }
}
