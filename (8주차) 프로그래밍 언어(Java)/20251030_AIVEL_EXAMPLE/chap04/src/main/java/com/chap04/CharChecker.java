package com.chap04;

public class CharChecker {
    public static void main(String[] args) {
        char ch = 52; //아스키코드
        if(ch >= 'a' && ch <= 'z'){
            System.out.println(ch + "는 소문자임.");
        }else if(ch >= 'A' && ch <= 'Z'){
            System.out.println(ch + "는 대문자임.");
        }else if(ch >= '0' && ch <= '9'){
            System.out.println(ch + "는 숫자임.");
        }else{
            System.out.println(ch + "는 알파벳/숫자가 아님.");
        }
    }
}
