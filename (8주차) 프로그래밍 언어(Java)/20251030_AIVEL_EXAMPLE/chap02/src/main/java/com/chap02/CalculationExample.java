package com.chap02;

public class CalculationExample {
    public static void main(String[] args) {
        long totalLong = 0;
        double totalDouble = 0, number = 1.1;
        int intNum = 13;
        totalDouble = number + number;
        System.out.println(totalDouble);

        totalDouble = number - number;
        System.out.println(totalDouble);

        totalLong = 1000000 * 10000L;
        System.out.println(totalLong);

        totalDouble = 1 / 1000.0;
        System.out.println(totalDouble);

        intNum *= 2; // intNum = intNum * 2; intNum = 22
        System.out.println(intNum);

        intNum %= 2; // intNum = intNum % 2; intNum = 0
        System.out.println(intNum);
    }
}
