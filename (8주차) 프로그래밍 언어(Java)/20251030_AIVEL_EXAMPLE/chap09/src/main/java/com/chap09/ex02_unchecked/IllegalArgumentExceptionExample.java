package com.chap09.ex02_unchecked;

public class IllegalArgumentExceptionExample {
    public static void main(String[] args) {
        try {
            Thread.sleep(-1);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException 발생: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException 발생: " + e.getMessage());
        }
    }
}
