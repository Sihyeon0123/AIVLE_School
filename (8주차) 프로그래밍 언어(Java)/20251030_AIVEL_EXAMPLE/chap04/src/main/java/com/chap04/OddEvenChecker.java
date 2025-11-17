package com.chap04;

import java.util.Scanner;
public class OddEvenChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num%2 != 0){
            System.out.println(num + "은 홀수이다.");
        }else{
            System.out.println(num + "은 짝수이다.");
        }
        sc.close();
    }
}
