package com.chap03;

public class MainArgumentsExample {
    public static void main(String[] args) {
        for(String arg : args){
            //arg 내부의 지역변수로 할당
            System.out.println(arg);
        }
    }
}
