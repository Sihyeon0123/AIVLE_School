package com.chap03;

public class StringCompareExample {
    public static void main(String[] args) {
        String firstString = "Hello World";
        String secondString = "Hello World";
        String thirdString = "hello world";
        int comparisonResult = firstString.compareTo(secondString);
        System.out.println(comparisonResult);
        boolean equalsResult = firstString.equals(secondString);
        System.out.println(equalsResult);

        comparisonResult = firstString.compareTo(thirdString);
        equalsResult = firstString.equals(thirdString);
        System.out.println(comparisonResult);
        System.out.println(equalsResult);
    }
}
