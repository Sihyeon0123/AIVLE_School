package com.chap02;

public class OverflowExample {
    public static void main(String[] args) {
        int maxInt = Integer.MAX_VALUE;
        int overflowExample = maxInt + 1;

        System.out.println("Integer.MAX_VALUE :" + maxInt);
        System.out.println("overflow Result : " + overflowExample);
    }
}
