package com.chap09.ex02_unchecked;

@SuppressWarnings("unused")
public class ClassCastExceptionExample {
    public static void main(String[] args) {
        try{
            Object obj = Integer.valueOf(32); // 다운 캐스트
            String str = (String) obj; // 사실상 Integer 객체를 String 객체 캐스트 하려고 시도
        }catch (ClassCastException e){
            System.out.println("ClassCastException 발생: " + e.getMessage());
        }
    }
}
