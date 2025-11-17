package com.chap03;

public class StringMethodDemo {
    public static void main(String[] args) {
        String orginalString = " Java Programming "; //orgStr
        String subString = orginalString.substring(5);
        System.out.println(subString);

        String lowerCaseString = orginalString.toLowerCase();
        System.out.println(lowerCaseString);

        String upperCaseString = orginalString.toUpperCase();
        System.out.println(upperCaseString);

        String trummedString = orginalString.trim();
        System.out.println(trummedString);
    }
}
