package com.chap03;

public class StringComparisonDemo {
    public static void main(String[] args) {
        String stringNew = new String("Hello World");

        String stringLiteral1 = "Hello World";
        String stringLiteral2 = "Hello World";

        System.out.println(stringNew == stringLiteral1); //false
        System.out.println(stringLiteral1 == stringLiteral2); //true

        System.out.println(stringNew != stringLiteral1); //true
        System.out.println(stringLiteral1 != stringLiteral2); //false

    }
}
