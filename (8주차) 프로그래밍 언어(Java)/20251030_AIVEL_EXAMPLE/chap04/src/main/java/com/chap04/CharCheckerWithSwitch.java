package com.chap04;

public class CharCheckerWithSwitch {
    public static void main(String[] args) {
        int num = 3;
        switch (num){
            case 1 :
                System.out.println("한개");
                break;
            case 2 :
                System.out.println("두개");
                break;
            case 3 :
            case 4 :
                System.out.println("서너개");
                break;
            case 5 :
                System.out.println("다섯개");
                break;
        }
    }
}
