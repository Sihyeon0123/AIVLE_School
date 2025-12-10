package com.chap09.ex02_unchecked;

@SuppressWarnings({"unused", "null"})
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        try {
            String text = null;
            int length = text.length();
        }catch (NullPointerException e){
            System.out.println("NullPointerException 발생: " + e.getMessage());
        }

        System.out.println("프로그램 계속 실행됨.");
    }
}
