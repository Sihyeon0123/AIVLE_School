package com.chap02;

public class OperatorPrecedence {
    public static void main(String[] args) {
        int a = 20, b = 10, c = 0, d = 20, e = 40, f = 30;
        boolean condition = true;

        // *와 + 연산자 예제
        // * 연산자가 + 연산자보다 우선순위가 높음.
        c = a + b * d;     // b*d를 먼저 계산하고 결과에 a를 더함.
        System.out.println("a + b * d = " + c);    // 결과: 220

        // 괄호 사용 예제
        // 괄호를 사용하면 괄호 안의 연산이 우선적으로 수행됨.
        c = (a + b) * d;   // a+b를 먼저 계산하고 결과에 d를 곱함.
        System.out.println("(a + b) * d = " + c);  // 결과: 600

        // &&와 || 연산자 예제
        // && 연산자가 || 연산자보다 우선순위가 높음.
        // condition이 true, 따라서 전체 조건은 true || false && false임.
        // && 연산이 먼저 수행되므로, false && false가 false를 결과로 함.
        // 최종적으로 true || false는 true임.
        // boolean result = condition || false && false;
        boolean result = condition || false;
        System.out.println("condition || false && false = " + result); // 결과: true

        // 비트 연산자 예제
        // & 연산자와 ^ 연산자 사용. ^ 연산자는 & 보다 우선순위가 낮음.
        c = e & f ^ d;     // 먼저 e&f가 수행되고, 그 결과에 d를 ^ 연산함.
        System.out.println("e & f ^ d = " + c);    // 결과: 28
    }    
}
