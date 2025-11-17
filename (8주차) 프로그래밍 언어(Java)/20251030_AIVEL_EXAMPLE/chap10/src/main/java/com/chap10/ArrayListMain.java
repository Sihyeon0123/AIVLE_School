package com.chap10;

import java.util.ArrayList;

public class ArrayListMain {
    public static void main(String[] args) {
        ArrayList<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("JavaScript");
        languages.add("Ruby");

        languages.add(2,"Go");
        System.out.println("Initial list: " + languages);
        System.out.println("Element at index 4: " + languages.get(4));

        languages.set(3, "TypeScript");
        languages.remove("Ruby");
        languages.remove(0);
        System.out.println("Size of list after modifications: " + languages.size());

        if (languages.contains("Go")) {
            System.out.println("List contains Go");
        }

        System.out.println("Updated list:");
        for(String lang : languages){
            System.out.println(lang);
        }
        // 리스트의 첫 번째 요소 찾기
        if (!languages.isEmpty()) {
            System.out.println("First element: " + languages.get(0));
        }

        languages.clear();
        System.out.println("List cleared. Is empty? " + languages.isEmpty());
    }
}
