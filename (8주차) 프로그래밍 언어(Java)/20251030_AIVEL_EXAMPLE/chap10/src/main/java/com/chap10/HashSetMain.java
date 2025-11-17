package com.chap10;

import java.util.HashSet;

public class HashSetMain {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(4);
        numbers.add(7);
        numbers.add(8);
        boolean isAdded =  numbers.add(4);
        System.out.println("HashSet contents: " + numbers);
        System.out.println("4 was added again: " + isAdded);
        // 요소 순서를 보장하지 않음을 확인하기 위해 더 많은 요소 추가
        numbers.add(1);
        numbers.add(3);
        System.out.println("HashSet after adding more elements: " + numbers);
        // 요소 검색
        if (numbers.contains(7)) {
            System.out.println("HashSet contains 7");
        }
        // 요소 삭제
        numbers.remove(8);
        System.out.println("HashSet after removing 8: " + numbers);
    }
}
