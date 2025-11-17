package com.chap10;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain {
    public static void main(String[] args) {
        Map<String,Integer> hashMap = new HashMap<>();
        hashMap.put("사과",10);
        hashMap.put("바나나",5);
        hashMap.put("체리", 10);

        hashMap.put(null,0);
        hashMap.put("포도", null);
        System.out.println(hashMap);

        System.out.println("사과의 수량: " + hashMap.get("사과"));
        System.out.println("포도의 수량: " + hashMap.get("포도")); // null 출력
        hashMap.remove("바나나");

        System.out.println("현재 HashMap:");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
        System.out.println("체리가 존재하는가? " + hashMap.containsKey("체리"));
        System.out.println("값 존재하는가? " + hashMap.containsValue(2));

        hashMap.clear();
        System.out.println("총 요소 수: " + hashMap.size());
    }
}
