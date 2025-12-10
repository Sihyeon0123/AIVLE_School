package com.chap09.ex02_unchecked;

@SuppressWarnings("unused")
public class NumberFormatExceptionExample {
    public static void main(String[] args) {
        try {
            int number = Integer.parseInt("abc");
        }catch (NumberFormatException e) {
            System.out.println("NumberFormatException 발생: " + e.getMessage());
        }
    }
}
