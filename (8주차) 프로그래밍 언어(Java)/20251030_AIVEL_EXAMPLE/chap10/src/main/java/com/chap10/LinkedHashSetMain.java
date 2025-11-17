package com.chap10;

import java.util.LinkedHashSet;

public class LinkedHashSetMain {
    public static void main(String[] args) {
        LinkedHashSet<String> str = new LinkedHashSet<>();

        str.add("hi");
        str.add("hello");
        str.add("java");
        str.add("bye");
        str.add("hi");
        System.out.println("LinkedHashSet contents: " + str);

        if(str.contains("java")){
            System.out.println("LinkedHashSet contains \"java\"");
        }

        str.remove("hi");
        System.out.println("LinkedHashSet after removing \"hi\": " + str);

        for(String subStr : str){
            System.out.println("Element: " + subStr);
        }
    }
}
