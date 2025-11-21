package com.chap02;

public class LogicalOperationExample {

    public static void main(String[] args) {
        int num1 = 3, num2 = 4;
        boolean logicResult = true;

        logicResult = (num1 > num2) && (num1 < num2);
        System.out.println(logicResult);

        logicResult = (num1 > num2) & (num1 < num2);
        System.out.println(logicResult);

        logicResult = (num1 > num2) || (num1 < num2);
        System.out.println(logicResult);

        logicResult = (num1 > num2) | (num1 < num2);
        System.out.println(logicResult);

        logicResult = (num1 > num2) ^ (num1 < num2);
        System.out.println(logicResult);

        logicResult = !(num1 > num2);
        System.out.println(logicResult);
        // 1. 4년에 한번씩 윤년이다.
        // 2. 100년 한번씩 윤년 아니다.
        // 3. 400년 한번씩 윤년이다.

        int year = 2004;
        logicResult = (year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0);

        System.out.println(logicResult);
    }
}
