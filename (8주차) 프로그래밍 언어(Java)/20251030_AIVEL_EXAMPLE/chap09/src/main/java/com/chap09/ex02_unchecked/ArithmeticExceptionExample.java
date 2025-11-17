package com.chap09.ex02_unchecked;

public class ArithmeticExceptionExample {
    public static void main(String[] args) {
        try{
            int result = 10 / 0;
            System.out.println("결과 : " + result);
        }catch (ArithmeticException e){
            System.out.println("ArithmeticException 발생: " + e.getMessage());
        }
    }
}
