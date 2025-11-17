package com.chap04;

public class AgeGroup {
    public static void main(String[] args) {
        int age = 17;
        if (age < 13) {
            System.out.println("어린이");
        } else if (age < 20) {
            System.out.println("청소년");
        } else if (age < 65) {
            System.out.println("성인");
        }else {
            System.out.println("노년");
        }
    }
}
