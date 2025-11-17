package com.chap03;

public class StringJoinDemo {
    public static void main(String[] args) {
        String string1 = "Hello";
        String string2 = "World";
        String string3 = "Java";
        String string4 = "Programming";
        String joinedWithSpace = String.join(" ",string1,string2,string3,string4);
        System.out.println(joinedWithSpace);

        String joinedWithComma = String.join(",",string1,string2,string3,string4);
        System.out.println(joinedWithComma);

        String joinedWithHyphen = String.join("-",string1,string2,string3,string4);
        System.out.println(joinedWithHyphen);
    }
}
