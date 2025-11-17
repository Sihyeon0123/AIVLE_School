package com.chap03;

public class StringManipulationDemo {
    public static void main(String[] args) {
        String baseString = "Hello";
        String stringToConcat = " World";
        String searchSting = "lo";
        String concatenatedSting = baseString.concat(stringToConcat);
        System.out.println(concatenatedSting);

        int index = concatenatedSting.indexOf(searchSting);
        System.out.println(index);

        boolean isEmpty = baseString.isEmpty();
        System.out.println(isEmpty);

        int length = concatenatedSting.length();
        System.out.println(length);
    }
}
