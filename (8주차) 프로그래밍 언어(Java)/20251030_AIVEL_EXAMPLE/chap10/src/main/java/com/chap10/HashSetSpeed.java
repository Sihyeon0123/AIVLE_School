package com.chap10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SuppressWarnings("unused")
public class HashSetSpeed {

    public static void main(String[] args) {
        int size = 1000000;
        HashSet<Integer> hashSet = new HashSet<>();
        List<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            hashSet.add(i);
            arrayList.add(i);
        }

        long startTime = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(size - 1);
        
        long endTime = System.nanoTime();
        long durationHashSet = endTime - startTime;

        startTime = System.nanoTime();
        boolean foundInArrayList = arrayList.contains(size - 1);
        endTime = System.nanoTime();
        long durationArrayList = endTime - startTime;

        // 결과 출력
        /*
        System.out.println("HashSet 검색 시간: " + durationHashSet + " 나노초");
        System.out.println("ArrayList 검색 시간: " + durationArrayList + " 나노초");
        */
        // 0.0000355초 3/100 밀리센컨드
        System.out.println("HashSet 검색 시간: " + (durationHashSet / 1_000_000_000.0) + " 초");
        // 5밀리세컨드
        System.out.println("ArrayList 검색 시간: " + (durationArrayList / 1_000_000_000.0) + " 초");

    }
}
