package com.chap02;

public class ComparisonOperatorExample {

    public static void main(String[] args) {
        int firstNumber = 10, secondNumber = 20, thirdNumber = 30;
        boolean comparisonResult = true;

        comparisonResult = firstNumber > secondNumber;
        System.out.println(comparisonResult);

        comparisonResult = firstNumber < secondNumber;
        System.out.println(comparisonResult);

        comparisonResult = firstNumber >= secondNumber;
        System.out.println(comparisonResult);

        comparisonResult = (firstNumber + thirdNumber) <= secondNumber;
        System.out.println(comparisonResult);

        comparisonResult = firstNumber == secondNumber;
        System.out.println(comparisonResult);

        comparisonResult = firstNumber != secondNumber;
        System.out.println(comparisonResult);
    }
}
