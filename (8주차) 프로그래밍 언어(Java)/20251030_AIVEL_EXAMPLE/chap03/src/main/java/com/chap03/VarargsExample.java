package com.chap03;

public class VarargsExample {
    public static void printNumbers(int num, int... numbers) {
        // numbers 지역 int 배열
        for(int number : numbers){
            System.out.println(number);
        }
    }
    public static void main(String[] args) {
        printNumbers(1,2,3,4,5,6,7);
        printNumbers(10,20);
    }
}
