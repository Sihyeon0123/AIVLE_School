package com.chap02;

public class UnaryOperatorExample {
    public static void main(String[] args) {
        int number = 5;
        int result = 0;

        result = number++; // number = number + 1; number = 6
        System.out.println("number = " + number);
        System.out.println("result = " + result);

        number = 5;
        result = ++number; // number = number + 1; number = 6
        System.out.println("number = " + number);
        System.out.println("result = " + result);

        number = 5;
        result = number++ + number--;
        System.out.println("number = " + number);
        System.out.println("result = " + result);

        result = ++number + --number;
        System.out.println("number = " + number);
        System.out.println("result = " + result);

        result = ++number + number++;
        System.out.println("number = " + number);
        System.out.println("result = " + result);
    }
}
