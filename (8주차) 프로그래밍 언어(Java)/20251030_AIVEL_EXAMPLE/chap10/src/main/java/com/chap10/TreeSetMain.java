package com.chap10;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();
        // 요소 추가
        numbers.add(10);
        numbers.add(5);
        numbers.add(2);
        numbers.add(15);
        System.out.println("TreeSet contents: " + numbers);

        long startTime = System.nanoTime();
        boolean foundInTreeSet = numbers.contains(5);
        long endTime = System.nanoTime();
        long durationTreeSet = endTime - startTime;
        // 1/100 밀리세컨드
        System.out.println("TreeSet 검색 시간: " + (durationTreeSet  / 1_000_000_000.0) + " 초");

        if(numbers.contains(5)){
            System.out.println("TreeSet contains 5");
        }
        numbers.remove(10);
        System.out.println("TreeSet after removing 10: " + numbers);

        // 첫 번째 요소와 마지막 요소 접근
        System.out.println("First element: " + ((TreeSet)numbers).first());
        System.out.println("Last element: " + ((TreeSet)numbers).last());
    }
}
