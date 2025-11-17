package com.chap04;

public class WhileDemo {
    public static void main(String[] args) {
        /*
        for(카운터 초기화; 조건식; 카운터 증가){
            실행문
        }
        */
        int i=0; //카운터 초기화
        while(i < 10){
            if(i<5){
                System.out.println(i + ": i는 5보다 작습니다.");
            } else if (i == 5) {
                System.out.println(i + ": i는 5입니다.");
            }else {
                System.out.println(i + ": i는 5보다 큽니다.");
            }
            i++; // 카운터 증가
        }
    }
}
