package com.chap04;

public class DoWhileDemo {
    public static void main(String[] args) {
        int i = 1, j = 1;
        while (i < 1){
            System.out.println(i+"번째 반복 while");
            i++;
        }

        do{
            System.out.println(j+"번째 반복 do while");
            j++;
        }while (j < 1);
        System.out.println("do while의 j 값 : " + j);
    }
}
